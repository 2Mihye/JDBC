package com.kh.MVC.Orders;

import java.util.List;

import com.kh.MVC.Singleton.Product.ProductDTO;

public class OrderController { // DAO�� VIEW ���� �� ���� ��� �޼���
	private OrderDAO dao;
	public OrderController(OrderDAO dao) {
		this.dao = dao;
	}
	
	public double calculateTotalPrice(List<OrderDTO> orders) {
		double totalPrice = 0;
		for(OrderDTO totalP : orders) {
			totalPrice += totalP.getTotalPrice();
		}
		return totalPrice;
	}
	
	public List<OrderDTO> getAllOrder(){
		return dao.getAllOrders();
	}
}
