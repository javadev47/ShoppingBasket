package com.rbc.basketcost.common;

import java.math.BigDecimal;

public class ProductDTO {

	private final BigDecimal quantity;
	private final BigDecimal price;
	private final CostCalculation costCalculation;

	public BigDecimal getQuantity() {
		return quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public CostCalculation getCostCalculation() {
		return costCalculation;
	}

	public ProductDTO(BigDecimal quantity, BigDecimal price, CostCalculation costCalculation) {
		this.quantity = quantity;
		this.price = price;
		this.costCalculation = costCalculation;
	}
}
