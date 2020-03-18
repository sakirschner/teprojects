package com.techelevator.ShoppingCart.model;

public interface OrderItemDAO {

	public void saveOrderItem(int orderId, long productId, int quantity);
	
}
