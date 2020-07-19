package com.ordershop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShopOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String orderId;
	String orderStatus;
	String token;
	
}
