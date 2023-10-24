package com.kh.MVC.Orders;

import java.util.List;

public class OrderView { // 보여지는 화면 출력
 public void showOrderList(List<OrderDTO> orders) {
	 for(OrderDTO o : orders) {
		 System.out.println("주문 번호 : " + o.getOrderID());
		 System.out.println("주문 날짜 : " + o.getOrderDate());
		 System.out.println("메뉴 이름 : " + o.getMenuName());
		 System.out.println("주문 수량 : " + o.getQuantity());
		 System.out.println(" 총  합 : " + o.getTotalPrice());
		 System.out.println("===========================================================");
	 }
 }
 
 public void showTotalPrice(double totalPrice) {
	 System.out.println("총 가격 : " + totalPrice);
 }
}
