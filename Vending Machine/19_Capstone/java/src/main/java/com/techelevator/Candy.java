package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Item {

	public Candy(String itemLocation, String itemName, BigDecimal itemPrice) { 
		super(itemLocation, itemName, itemPrice, "Candy", 5); 
	}

}
