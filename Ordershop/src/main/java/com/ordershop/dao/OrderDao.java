package com.ordershop.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ordershop.entity.ShopOrder;

public interface OrderDao extends JpaRepository<ShopOrder, Long> {	
	

	public ShopOrder findByOrderId(String orderId);
	public List<ShopOrder>  findAll();

}
