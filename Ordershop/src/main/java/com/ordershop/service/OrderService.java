package com.ordershop.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.persistence.Entity;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordershop.dao.OrderDao;
import com.ordershop.entity.ShopOrder;
import com.ordershop.model.OrderDetail;
import com.ordershop.util.Jwtutil;

@Service
@Transactional
public class OrderService {
	
	@Autowired
	Jwtutil jwtutil;
	
	@Autowired 
	OrderDao orderDao;
	
	public OrderDetail getOrderDetails(String jwt)
	{
		OrderDetail detail = new OrderDetail();
		String orderId = getRandomOrderid();
		//validate jwt		
		if(jwtutil.validateToken(jwt)) {
			
			// save it in database
			ShopOrder entity = new ShopOrder();			
			entity.setOrderId(orderId);
			entity.setOrderStatus("Success");
			entity.setToken(jwt);			
			orderDao.save(entity);			
		}
		
		// check if the id saved
		
		ShopOrder order = orderDao.findByOrderId(orderId);
		if(null != order)
		{
			detail.setOrderId(order.getOrderId());
			detail.setOrderStatus(order.getOrderStatus());
			detail.setToken(order.getToken());
		}else
		{
			detail.setOrderId(null);
			detail.setOrderStatus("Order Placemnet failed, Try again...");
		}
		
		return detail;
	}

	private String getRandomOrderid() {		
		Random random = new Random();		
		return "order-"+random.nextLong();
	}

	public List<OrderDetail> getAllOrderDetails(String token) {
		// TODO Auto-generated method stub
		List<OrderDetail> orderDetails =  new ArrayList<>();
		if(jwtutil.validateToken(token)) {
			List<ShopOrder> list = orderDao.findAll();
			for (ShopOrder shopOrder : list) {
				OrderDetail detail = new OrderDetail(shopOrder.getOrderId(),shopOrder.getOrderStatus(),shopOrder.getToken());
				orderDetails.add(detail);
			}
		}
		return orderDetails;
	}

}
