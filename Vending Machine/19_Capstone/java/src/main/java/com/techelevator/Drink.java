package com.techelevator;

import java.math.BigDecimal;

public class Drink extends Item {

	public Drink(String itemLocation, String itemName, BigDecimal itemPrice) { 
		super(itemLocation, itemName, itemPrice, "Drink", 5); 
}
}