package com.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.common.Payment;
import com.order.entity.Order;
import com.order.service.OrderService;
import com.order.service.PaymentClient;
import com.order.vo.TransactionRequest;
import com.order.vo.TransactionResponse;

@RestController
@RequestMapping(value="/order")
public class OrderController {
	private OrderService orderService;
    
	@Autowired
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	 @Autowired
	    private PaymentClient paymentClient;

//	@PostMapping(value="/saveOrder")
//	public ResponseEntity<Order> placeOrder(@RequestBody Order order){
//		return new ResponseEntity<Order>(oServ.placeOrder(order),HttpStatus.CREATED);
//	}
//	
//	@GetMapping(value="/getorders")
//	public ResponseEntity<List<Order>> getAllOrders(){
//		return new ResponseEntity<List<Order>>(oServ.getAllOrders(),HttpStatus.OK);
//		
//	}
//	
//	@GetMapping(value="/findOrder/{order_id}")
//	public ResponseEntity<Order> findOrder(@RequestBody Long order_id){
//		return new ResponseEntity<Order> (oServ.findOrder(order_id),HttpStatus.ACCEPTED);
//	}
	
	
	
	
	@PostMapping(value = "/placeOrder")
    public ResponseEntity<TransactionResponse> placeOrder(@RequestBody TransactionRequest transactionRequest){

       Order order= transactionRequest.getOrder();
       Order savedOrder=orderService.placeOrder(order);
       Payment payment=transactionRequest.getPayment();

       payment.setAmount(order.getAmount());
       payment.setOrderId(savedOrder.getOrderId());

       // REST API CALL TO PAYMENT SERVICE

       Payment savedPayment=paymentClient.makePayment(payment);

       TransactionResponse transactionResponse=new TransactionResponse();
       transactionResponse.setOrderId(savedOrder.getOrderId());
       transactionResponse.setOrderName(savedOrder.getOrderName());
       transactionResponse.setAmount(savedOrder.getAmount());
       transactionResponse.setTransactionId(savedPayment.getTransactionId());
       transactionResponse.setPaymentStatus(savedPayment.getPaymentStatus());

       return new ResponseEntity<TransactionResponse>(transactionResponse,HttpStatus.CREATED);
    }
	
	

}
