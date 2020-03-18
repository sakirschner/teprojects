package com.techelevator.ShoppingCart.model;

import java.math.BigDecimal;
import java.util.List;


public class Order {

	private int id;
	private String customerName;
	private String streetAddress1;
	private String streetAddress2;
	private String city;
	private String state;
	private String zipCode;
	private List<OrderItem> cartItems;
	private BigDecimal total;
	private int numOfItems;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getStreetAddress1() {
		return streetAddress1;
	}

	public void setStreetAddress1(String streetAddress1) {
		this.streetAddress1 = streetAddress1;
	}

	public String getStreetAddress2() {
		return streetAddress2;
	}

	public void setStreetAddress2(String streetAddress2) {
		this.streetAddress2 = streetAddress2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public List<OrderItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<OrderItem> cartItems) {
		this.cartItems = cartItems;
	}

	public BigDecimal getTotal() {
		return total;
	}
	
	// loops through every product in the list and calculates
	// the price * quantity and sums them to get the entire total

	public void setTotal(List<OrderItem> cartItems) {
		BigDecimal grandTotal = new BigDecimal(0);
		for(OrderItem item: cartItems) {
			grandTotal = grandTotal.add(item.getTotal());
		}
		this.total = grandTotal;
	}

	public int getNumOfItems() {
		return numOfItems;
	}
	
	// loops through every item in the cart and checks the
	// quantity to get a number of how many total products
	// are in the cart

	public void setNumOfItems(List<OrderItem> cartItems) {
		int items = 0;
		for(OrderItem item: cartItems) {
			items = items + item.getQuantity();
		}
		this.numOfItems = items;
	}

}
