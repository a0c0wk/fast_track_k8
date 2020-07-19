package com.ordershop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.ordershop.model.OrderDetail;
import com.ordershop.model.OrderDetailsList;
import com.ordershop.model.OrderInput;
import com.ordershop.service.OrderService;


@RestController
public class OrderController {
	
	@Autowired
	OrderService orderservice;
	
	@PostMapping("/neworder")
	public ResponseEntity<OrderDetail> OrderConfirmation(@RequestBody OrderInput input)
	{
		
		OrderDetail detail = orderservice.getOrderDetails(input.getToken());
		
		if(null != detail.getOrderId())
			return new ResponseEntity<OrderDetail>(detail, HttpStatus.OK);
		else
			return new ResponseEntity<OrderDetail>(detail, HttpStatus.NOT_FOUND);
		
	}

	@GetMapping("/allorder")
	public ResponseEntity<OrderDetailsList> getAllOrder(@RequestHeader String jwt)
	{
		OrderDetailsList list = new OrderDetailsList();
		List<OrderDetail> details = orderservice.getAllOrderDetails(jwt);
		
			list.setOrderDetails(details);
		
		if(!details.isEmpty())
			return new ResponseEntity<OrderDetailsList>(list,HttpStatus.OK);
		else
			return new ResponseEntity<OrderDetailsList>(list, HttpStatus.NOT_FOUND);
		
	}
	
}
