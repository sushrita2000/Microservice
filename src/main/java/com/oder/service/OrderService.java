package com.oder.service;

import java.util.List;

import com.order.entity.Order;

public interface OrderService {
	public Order placeOrder(Order order);
	
	public List<Order> getAllOrders();
	
	public Order findOrder(Long order_id);

}
