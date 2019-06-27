package com.beijl695.service;

import java.util.List;

import com.beijl695.entity.Order;
import com.beijl695.entity.PageBean;

public interface OrderService {

	public void saveOrder(Order order);
	
	public List<Order> findOrder(Order s_order, PageBean pageBean);
	
	public Long getOrderCount(Order s_order);
	
	public void updateOrderStatus(int status, String orderNo);
	
	public Order getOrderById(int id);
}
