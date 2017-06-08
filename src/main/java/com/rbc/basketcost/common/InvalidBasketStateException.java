package com.rbc.basketcost.common;

public class InvalidBasketStateException extends RuntimeException {
	public InvalidBasketStateException(String cause) {
		super(cause);
	}
}
