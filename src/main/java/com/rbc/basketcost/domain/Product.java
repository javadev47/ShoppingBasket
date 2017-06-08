package com.rbc.basketcost.domain;

import com.rbc.basketcost.common.CostCalculation;

import java.math.BigDecimal;

public class Product {

	private final int id;
	private final String productName;
	private final BigDecimal costPerUnit;
	private final BigDecimal costPerUnitWeight;

	public Product(int id, String productName, BigDecimal costPerUnit, BigDecimal costPerUnitWeight) {
		this.id = id;
		this.productName = productName;
		this.costPerUnit = costPerUnit;
		this.costPerUnitWeight = costPerUnitWeight;
	}

	public int getId() {
		return id;
	}

	public String getProductName() {
		return productName;
	}

	public BigDecimal getCostPerUnit() {
		return costPerUnit;
	}

	public BigDecimal getCostPerUnitWeight() {
		return costPerUnitWeight;
	}
}