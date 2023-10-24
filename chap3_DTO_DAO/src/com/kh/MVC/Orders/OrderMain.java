package com.kh.MVC.Orders;

import java.util.List;

public class OrderMain {

	public static void main(String[] args) {
		OrderDAO dao = new OrderDAO();
		OrderController controller = new OrderController(dao);
		OrderView view = new OrderView();
		
		List<OrderDTO> orders = controller.getAllOrder();
		view.showOrderList(orders);
		
		double totalPrice = controller.calculateTotalPrice(orders);
		view.showTotalPrice(totalPrice);
	}
}
