package com.order.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="ORDER_DETAILS")
public class Order{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long order_id;
	private String order_name;
	private int quantity;
	private double amount;
	
	

}
