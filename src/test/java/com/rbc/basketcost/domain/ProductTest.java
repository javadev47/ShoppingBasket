package com.rbc.basketcost.domain;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import org.junit.Test;

public class ProductTest {

	@Test
	public void testProduct() {

		final int id = 1;
		final String productName = "PRODUCT";
		final BigDecimal costPerUnit = BigDecimal.ONE;
		final BigDecimal costPerUnitEWeight = BigDecimal.TEN;

		Product product = new Product(id, productName, costPerUnit, costPerUnitEWeight);

		assertEquals(id, product.getId());
		assertEquals(productName, product.getProductName());
		assertEquals(costPerUnit, product.getCostPerUnit());
		assertEquals(costPerUnitEWeight, product.getCostPerUnitWeight());
	}

}
