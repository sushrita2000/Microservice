package com.order.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.entity.Order;
import com.order.repository.OrderRepository;

import lombok.Data;
@Service
public class OrderServiceImpl implements OrderService{
	
	private OrderRepository orderRapo;
	
    @Autowired
	public void setOrderRapo(OrderRepository orderRapo) {
		this.orderRapo = orderRapo;
	}

	public Order placeOrder(Order order) {
		// TODO Auto-generated method stub
		return orderRapo.save(order);
	}

	@Override
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return orderRapo.findAll();
	}

	@Override
	public Order findOrder(Long order_id) {
		// TODO Auto-generated method stub
		return orderRapo.findById(order_id).get();
	}
	
	
}
