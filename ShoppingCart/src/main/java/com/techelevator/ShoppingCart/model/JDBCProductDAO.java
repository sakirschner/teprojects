package com.techelevator.ShoppingCart.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCProductDAO implements ProductDAO {
	
	private JdbcTemplate jdbcTemplate;

	//creates the database connection
	
	@Autowired
	public JDBCProductDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	//creates a product object based off a database row
	
	private Product mapRowToProduct(SqlRowSet row) {
		Product product = new Product();
		product.setId(row.getInt("product_id"));
		product.setName(row.getString("name"));
		product.setDescription(row.getString("description"));
		BigDecimal price = new BigDecimal(row.getDouble("price"));
		product.setPrice(price);
		product.setImageName(row.getString("image_name"));
		product.setRating(row.getDouble("avg_rating"));
		return product;
	}
	
	//gets every product in the database
	
	@Override
	public List<Product> getAllProducts() {
		List<Product> allProducts = new ArrayList<>();
		SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT * FROM products");
		while (results.next()) {
			allProducts.add(mapRowToProduct(results));
		}
		return allProducts;
	}

	//gets an individual product from the database by its id
	
	@Override
	public Product getProductById(int id) {
		Product product = new Product();
		SqlRowSet results = jdbcTemplate.queryForRowSet("SELECT * FROM products WHERE product_id = ?", id);
		if (results.next()) {
			product = mapRowToProduct(results);
		}
		return product;
	}

}
