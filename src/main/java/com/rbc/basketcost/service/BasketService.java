package com.rbc.basketcost.service;

import com.rbc.basketcost.domain.Basket;

import java.math.BigDecimal;

public interface BasketService {
	BigDecimal calculateTotalCost(Basket basket);
}
