package com.kh.MVC.Orders;

import java.util.List;

public class OrderView { // �������� ȭ�� ���
 public void showOrderList(List<OrderDTO> orders) {
	 for(OrderDTO o : orders) {
		 System.out.println("�ֹ� ��ȣ : " + o.getOrderID());
		 System.out.println("�ֹ� ��¥ : " + o.getOrderDate());
		 System.out.println("�޴� �̸� : " + o.getMenuName());
		 System.out.println("�ֹ� ���� : " + o.getQuantity());
		 System.out.println(" ��  �� : " + o.getTotalPrice());
		 System.out.println("===========================================================");
	 }
 }
 
 public void showTotalPrice(double totalPrice) {
	 System.out.println("�� ���� : " + totalPrice);
 }
}
