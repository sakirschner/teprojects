package com.techelevator;

import java.math.BigDecimal;

public class Chip extends Item {
	
	public Chip(String itemLocation, String itemName, BigDecimal itemPrice) { 
		super(itemLocation, itemName, itemPrice, "Chip", 5);
	}

}
