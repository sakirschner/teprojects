package com.techelevator.ShoppingCart.model;

import java.util.List;

public interface ProductDAO {

	public List<Product> getAllProducts();
	public Product getProductById(int id);
	
}
