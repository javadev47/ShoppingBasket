package com.rbc.basketcost.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.rbc.basketcost.common.CostCalculation;
import com.rbc.basketcost.common.Item;
import com.rbc.basketcost.domain.Basket;

import java.math.BigDecimal;

import com.rbc.basketcost.domain.Product;
import org.junit.Test;
import org.mockito.Mockito;

public class BasketServiceImplTest {

	private final ProductService productService = Mockito.mock(ProductService.class);
	private final BasketService basketService = new BasketServiceImpl(productService);

	private static final int lemonProductId = 1;
	private static final BigDecimal numOfLemons = BigDecimal.valueOf(5);
	private static final BigDecimal weightOfLemons = BigDecimal.ONE;
	private static final BigDecimal pricePerUnitLemon = new BigDecimal("0.10");
	private static final BigDecimal lemonPricePerUnitWeight = BigDecimal.ONE;

	private static final int orangeProductId = 2;
	private static final BigDecimal numOfOranges = BigDecimal.valueOf(10);
	private static final BigDecimal weightOfOranges = BigDecimal.ONE;
	private static final BigDecimal pricePerUnitOrange = new BigDecimal("0.20");
	private static final BigDecimal orangePricePerUnitWeight = new BigDecimal("1.20");

	private static final int bananaProductId = 3;
	private static final BigDecimal numOfBananas = BigDecimal.valueOf(15);
	private static final BigDecimal weightOfBananas = BigDecimal.ONE;
	private static final BigDecimal pricePerUnitBanana = new BigDecimal("0.30");
	private static final BigDecimal bananaPricePerUnitWeight = new BigDecimal("1.30");

	private void setUp() {

		final Product productLemon = new Product(lemonProductId, "LEMONS", pricePerUnitLemon, lemonPricePerUnitWeight);
		final Product productOrange = new Product(orangeProductId, "ORANGE", pricePerUnitOrange,
			orangePricePerUnitWeight);
		final Product productBanana = new Product(lemonProductId, "BANANA", pricePerUnitBanana,
			bananaPricePerUnitWeight);

		when(productService.getProduct(lemonProductId)).thenReturn(productLemon);
		when(productService.getProduct(orangeProductId)).thenReturn(productOrange);
		when(productService.getProduct(bananaProductId)).thenReturn(productBanana);
	}

	@Test
	public void testCalculateBasketCostByWeight() {

		setUp();

		Basket basket = new Basket();
		basket.addItem(new Item(lemonProductId, weightOfLemons, CostCalculation.CALCULATE_COST_BY_WEIGHT));
		basket.addItem(new Item(orangeProductId, weightOfOranges, CostCalculation.CALCULATE_COST_BY_WEIGHT));
		basket.addItem(new Item(bananaProductId, weightOfBananas, CostCalculation.CALCULATE_COST_BY_WEIGHT));
		BigDecimal totalCost = basketService.calculateTotalCost(basket);

		assertEquals(new BigDecimal("3.50"), totalCost);

	}

	@Test
	public void testCalculateBasketCostByNumberOfItems() {

		setUp();

		Basket basket = new Basket();
		basket.addItem(new Item(lemonProductId, numOfLemons, CostCalculation.CALCULATE_COST_BY_UNIT));
		basket.addItem(new Item(orangeProductId, numOfOranges, CostCalculation.CALCULATE_COST_BY_UNIT));
		basket.addItem(new Item(bananaProductId, numOfBananas, CostCalculation.CALCULATE_COST_BY_UNIT));
		BigDecimal totalCost = basketService.calculateTotalCost(basket);

		assertEquals(new BigDecimal("7.00"), totalCost);

	}

	@Test
	public void testCalculateBasketCostByMixtureOfWeightAndNumberOfItems() {

		setUp();

		Basket basket = new Basket();
		basket.addItem(new Item(lemonProductId, numOfLemons, CostCalculation.CALCULATE_COST_BY_UNIT));
		basket.addItem(new Item(orangeProductId, weightOfOranges, CostCalculation.CALCULATE_COST_BY_WEIGHT));
		basket.addItem(new Item(bananaProductId, numOfBananas, CostCalculation.CALCULATE_COST_BY_UNIT));
		BigDecimal totalCost = basketService.calculateTotalCost(basket);

		assertEquals(new BigDecimal("6.20"), totalCost);

	}

}
