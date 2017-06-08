package com.rbc.basketcost.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.rbc.basketcost.common.CostCalculation;
import com.rbc.basketcost.common.EmptyBasketException;
import com.rbc.basketcost.common.InvalidBasketStateException;
import com.rbc.basketcost.common.Item;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasketTest {

	private static final int id1 = 1;
	private static final BigDecimal quantity1 = BigDecimal.ONE;
	private static final CostCalculation costCalculationByUnit = CostCalculation.CALCULATE_COST_BY_UNIT;

	private static final int id2 = 2;
	private static final BigDecimal quantity2 = BigDecimal.TEN;
	private static final CostCalculation costCalculationByWeight = CostCalculation.CALCULATE_COST_BY_WEIGHT;

	private static final int id3 = 3;
	private static final BigDecimal quantity3 = BigDecimal.TEN;

	@Test
	public void testAddItemsToBasket() {

		final Basket basket = new Basket();
		final Item item1 = new Item(id1, quantity1, costCalculationByUnit);
		final Item item2 = new Item(id2, quantity2, costCalculationByWeight);

		basket.addItem(item1);
		basket.addItem(item2);

		Item basketItem1 = basket.getBasketItems().get(0);
		assertEquals(id1, basketItem1.getId());
		assertEquals(quantity1, basketItem1.getQuantity());
		assertEquals(costCalculationByUnit, basketItem1.getCostCalculation());

		Item basketItem2 = basket.getBasketItems().get(1);
		assertEquals(id2, basketItem2.getId());
		assertEquals(quantity2, basketItem2.getQuantity());
		assertEquals(costCalculationByWeight, basketItem2.getCostCalculation());
	}

	@Test
	public void testRemoveItemsFromBasket() {

		final Basket basket = new Basket();
		final Item item1 = new Item(id1, quantity1, costCalculationByUnit);
		final Item item2 = new Item(id2, quantity2, costCalculationByWeight);
		final Item item3 = new Item(id3, quantity3, costCalculationByWeight);

		basket.addItem(item1);
		basket.addItem(item2);

		assertEquals(false, basket.removeItem(item3));
		assertEquals(true, basket.removeItem(item1));
		assertEquals(true, basket.removeItem(item2));
	}

	@Test(expected = EmptyBasketException.class)
	public void testEmptyBasketException() {

		final Basket basket = new Basket();
		final Item item1 = new Item(id1, quantity1, costCalculationByUnit);
		basket.removeItem(item1);

	}
}
