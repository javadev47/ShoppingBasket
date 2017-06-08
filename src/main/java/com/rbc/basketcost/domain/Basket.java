package com.rbc.basketcost.domain;

import com.rbc.basketcost.common.EmptyBasketException;
import com.rbc.basketcost.common.InvalidBasketStateException;
import com.rbc.basketcost.common.Item;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Basket {

	private final List<Item> basketItems;

	public Basket() {
		this.basketItems = new ArrayList<Item>();
	}

	public Basket(List<Item> basketItems) {
		this.basketItems = basketItems;
	}

	public List<Item> getBasketItems() {
		return basketItems;
	}

	public void addItem(Item basketItem) {
		basketItems.add(basketItem);
	}

	public boolean removeItem(Item basketItem) {

		boolean removed = false;

		if (basketItems.size() == 0) {
			throw new EmptyBasketException("Basket is empty");
		}
		Iterator<Item> it = basketItems.iterator();

		while (it.hasNext()) {
			if (it.next().getId() == basketItem.getId()) {
				it.remove();
				removed = true;
				break;
			}
		}
		return removed;
	}

}
