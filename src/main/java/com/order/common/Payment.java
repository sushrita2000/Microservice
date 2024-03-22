package com.order.common;

import java.security.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
	
	private long pid;
	private String transactionId;
	private PaymentStatus paymentStatus;
	private Timestamp paymentDate;
	private long orderID;

}
