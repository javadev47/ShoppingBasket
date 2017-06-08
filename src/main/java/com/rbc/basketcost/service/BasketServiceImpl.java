package com.rbc.basketcost.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.rbc.basketcost.common.CostCalculation;
import com.rbc.basketcost.common.Item;
import com.rbc.basketcost.common.ProductDTO;
import com.rbc.basketcost.domain.Basket;
import com.rbc.basketcost.domain.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasketServiceImpl implements BasketService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BasketServiceImpl.class);
	private final ProductService productService;

	public BasketServiceImpl(ProductService productService) {
		this.productService = productService;
	}

	public BigDecimal calculateTotalCost(Basket basket) {

		if (basket == null) {
			throw new IllegalArgumentException("No basket has been supplied");
		}

		Function<Item, ProductDTO> productsMapper = item -> new ProductDTO(item.getQuantity(),
			productService.getProduct(item.getId()).getCostPerUnit(), item.getCostCalculation());

		List<ProductDTO> grocery = new ArrayList<>();

		for (Item item : basket.getBasketItems()) {
			Product product = productService.getProduct(item.getId());
			if (item.getCostCalculation().equals(CostCalculation.CALCULATE_COST_BY_UNIT)) {
				grocery.add(new ProductDTO(item.getQuantity(), product.getCostPerUnit(),
					CostCalculation.CALCULATE_COST_BY_UNIT));
			} else {
				grocery.add(new ProductDTO(item.getQuantity(), product.getCostPerUnitWeight(),
					CostCalculation.CALCULATE_COST_BY_WEIGHT));
			}
		}

		BigDecimal totalCost = BigDecimal.ZERO;

		Function<ProductDTO, BigDecimal> totalMapper = productDTO -> productDTO.getQuantity()
			.multiply(productDTO.getPrice());
		totalCost = grocery.stream().map(totalMapper).peek(System.out::println).reduce(BigDecimal.ZERO,
			BigDecimal::add);
		LOGGER.info("Items processed: " + grocery.size() + ", total cost: " + totalCost);

		return totalCost.setScale(2, BigDecimal.ROUND_UP);

	}

}
