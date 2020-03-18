package com.techelevator.ShoppingCart.model;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JDBCOrderItemDAO implements OrderItemDAO {

	private JdbcTemplate jdbcTemplate;

	//creates the database connection
	
	@Autowired
	public JDBCOrderItemDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// saves an order item to the database
	
	@Override
	public void saveOrderItem(int orderId, long productId, int quantity) {
		jdbcTemplate.update("INSERT INTO order_items(order_id, product_id, quantity)"
				+ " VALUES (?, ?, ?)", orderId, productId, quantity);
	}

}
