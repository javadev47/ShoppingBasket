package com.rbc.basketcost.common;

import java.math.BigDecimal;
import static org.junit.Assert.assertEquals;
import com.rbc.basketcost.common.CostCalculation;
import com.rbc.basketcost.common.Item;
import org.junit.Test;

public class BasketItemTest {

	@Test
	public void testBasketItem() {

		final int id = 1;
		final BigDecimal quantity = BigDecimal.ONE;
		final CostCalculation costCalculation = CostCalculation.CALCULATE_COST_BY_UNIT;

		final Item item = new Item(id, quantity, costCalculation);

		assertEquals(id, item.getId());
		assertEquals(quantity, item.getQuantity());
		assertEquals(costCalculation, item.getCostCalculation());

	}

}
