package com.rbc.basketcost.common;

import java.math.BigDecimal;

public class Item {

	private final int id;
	private final BigDecimal quantity;
	private final CostCalculation costCalculation;

	public Item(int id, BigDecimal quantity, CostCalculation costCalculation) {
		this.id = id;
		this.quantity = quantity;
		this.costCalculation = costCalculation;
	}

	public int getId() {
		return id;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public CostCalculation getCostCalculation() {
		return costCalculation;
	}

	@Override
	public String toString() {
		return String.format("Item : %s Quantity : %s ", id, quantity);
	}

}
