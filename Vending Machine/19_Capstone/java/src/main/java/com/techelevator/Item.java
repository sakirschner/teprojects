package com.techelevator;

import java.math.BigDecimal;

public class Item {

		private String itemLocation;
		private String itemName;
		private BigDecimal itemPrice;
		private String itemType;
		private int stockLevel = 5;
		
		public Item(String itemType) { 
			this.itemType = itemType;
		}
		
		public Item(String itemLocation, String itemName, 
				BigDecimal itemPrice, String itemType, int stockLevel) {  
			super();
			this.itemLocation = itemLocation;
			this.itemName = itemName;
			this.itemPrice = itemPrice;
			this.itemType = itemType;
			this.stockLevel = stockLevel;
		}

		public String getItemLocation() {
			return itemLocation;
		}
		
		public void setItemLocation(String itemLocation) {
			this.itemLocation = itemLocation;
		}

		public String getItemName() {
			return itemName;
		}

		public BigDecimal getItemPrice() {
			return itemPrice;
		}
		
		public void setItemPrice(BigDecimal itemPrice) {
			this.itemPrice = itemPrice;
		}

		public String getItemType() {
			return itemType;
		}
		
		public String getStockLevel() {
			if (this.stockLevel == 0) {
			return "Sold Out";
			}
				
			return Integer.toString(stockLevel);
		}
		
		public void deductStockLevel() {
			this.stockLevel = stockLevel - 1;
		}
		
		public String toString() {
			return getItemLocation() + " " + getItemName() + " " 
			+ getItemPrice() + " " + getItemType() + " " + getStockLevel();
		}
	}

