package com.rbc.basketcost.common;

public enum CostCalculation {

	CALCULATE_COST_BY_WEIGHT("By Weight"), CALCULATE_COST_BY_UNIT("By Unit");

	private final String name;

	CostCalculation(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
