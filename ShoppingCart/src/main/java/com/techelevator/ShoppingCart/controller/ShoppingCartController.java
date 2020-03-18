package com.techelevator.ShoppingCart.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.ShoppingCart.model.Order;
import com.techelevator.ShoppingCart.model.OrderDAO;
import com.techelevator.ShoppingCart.model.OrderItem;
import com.techelevator.ShoppingCart.model.OrderItemDAO;
import com.techelevator.ShoppingCart.model.Product;
import com.techelevator.ShoppingCart.model.ProductDAO;

@Controller
public class ShoppingCartController {

	// connects database

	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private OrderItemDAO orderItemDAO;

	// returns the store page with every product from the database

	@RequestMapping("/")
	public String displayStore(ModelMap map) {
		List<Product> allProducts = productDAO.getAllProducts();
		map.put("products", allProducts);
		return "store";
	}
	
	// adds a new product to the cart and redirects to the cart url

	@RequestMapping(path = "/", method = RequestMethod.POST)
	public String processAddingToCart(@RequestParam int quantity, @RequestParam int id, HttpSession session) {

		// declares list of items in the shopping cart
		List<OrderItem> cartItems;
		
		// instantiates a new order item
		OrderItem orderItem = new OrderItem();
		// grabs the product selected from the store page out of the database by its id
		Product product = productDAO.getProductById(id);
		
		// maps the item based off the values from the product in the database 
		orderItem.setName(product.getName());
		orderItem.setDescription(product.getDescription());
		orderItem.setPrice(product.getPrice());
		orderItem.setProductId(product.getId());
		orderItem.setQuantity(quantity);
		orderItem.setImageName(product.getImageName());
		orderItem.setTotal(product.getPrice().multiply(new BigDecimal(quantity)));

		// grabs the session attribute which will see if there are already items in the cart
		Order order = (Order) session.getAttribute("order");

		// if the session is empty the it instantiates a new item list
		// otherwise it will grab an already created list of items
		if (order == null) {
			order = new Order();
			cartItems = new ArrayList<>();
		} else {
			cartItems = order.getCartItems();
		}
		
		// if trying to order more of an existing item in the cart this will just increase 
		// the quantity instead of adding a new order item to the cart
		boolean itemExists = false;

		for (OrderItem checkItem : cartItems) {
			if (checkItem.getProductId() == product.getId()) {
				orderItem.setQuantity(checkItem.getQuantity() + orderItem.getQuantity());
				itemExists = true;
			}
		}

		if (!itemExists) {
			cartItems.add(orderItem);
		}

		// sets the total of each item in the cart to quantity * price
		for (int i = 0; i < cartItems.size(); i++) {
			if (cartItems.get(i).getName().equals(orderItem.getName())) {
				OrderItem reference = cartItems.get(i);
				reference.setQuantity(orderItem.getQuantity());
				reference.setTotal(orderItem.getPrice().multiply(new BigDecimal(orderItem.getQuantity())));
			}
		}
		
		// sets the values that can't be pulled from the database
		order.setCartItems(cartItems);
		order.setTotal(cartItems);
		order.setNumOfItems(cartItems);
		session.setAttribute("order", order);

		return "redirect:/cart";
	}

	// displays the shopping cart with all the selected items based on
	// the user's session
	
	@RequestMapping(path = "/cart", method = RequestMethod.GET)
	public String displayCart(HttpSession session) {
		Order order = (Order) session.getAttribute("order");
		return "cart";
	}
	
	// when a user checks out this will display the checkout form

	@RequestMapping(path = "/checkout", method = RequestMethod.GET)
	public String displayPersonalInfo(HttpSession session) {
		Order order = (Order) session.getAttribute("order");
		return "checkout";
	}
	
	// processes the order and saves it to the database

	@RequestMapping(path = "/checkout", method = RequestMethod.POST)
	public String processOrder(Order order, HttpSession session) {

		//saves order to the database
		orderDAO.saveOrder(order);
		
		//grabs the session attribute for all the cart items
		Order orderSession = (Order) session.getAttribute("order");
		
		//saves each item in the cart to the database as an order_item
		for (OrderItem item : orderSession.getCartItems()) {
			orderItemDAO.saveOrderItem(order.getId(), item.getProductId(), item.getQuantity());
		}

		return "redirect:/confirmation";
	}
	
	// when an order is successful displays order confirmation 
	// and clears the session 
	
	@RequestMapping("/confirmation")
	public String displayCOnfirmation(HttpSession session) {
		session.invalidate();
		return "confirmation";
	}
	
	// redirects to home and clears the session if the user
	// chooses to clear their cart
	
	@RequestMapping("/clear")
	public String processClear(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
