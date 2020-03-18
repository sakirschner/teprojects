package com.techelevator.ShoppingCart.model;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCOrderDAO implements OrderDAO {

	private JdbcTemplate jdbcTemplate;

	//creates the database connection
	
	@Autowired
	public JDBCOrderDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// saves an order to the database
	
	@Override
	public void saveOrder(Order order) {
		int id = getNextId();
		jdbcTemplate.update("INSERT INTO orders(order_id, customer_name, street_address1, street_address2, city, state, zip_code) "
				+ "VALUES (?,?,?,?,?,?,?)",
				id, order.getCustomerName(), order.getStreetAddress1(), 
							order.getStreetAddress2(), order.getCity(), order.getState(), order.getZipCode());
		order.setId(id);
	}
	
	// gets the next id available to save an order in 
	// increasing order

	private int getNextId() {
		String sqlSelectNextId = "SELECT MAX(order_id) FROM orders";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		int id = 0;
		if (results.next()) {
			id = results.getInt(1) + 1;
		} else {
			throw new RuntimeException("Something strange happened, unable to select next order id from sequence");
		}
		return id;
	}

}
