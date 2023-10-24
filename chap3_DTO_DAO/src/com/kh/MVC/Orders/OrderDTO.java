package com.kh.MVC.Orders;

import java.sql.Date;

public class OrderDTO { // 멤버변수 생성자 getter setter
	private int orderID;
	private int cafeID;
	private int menuID;
	private Date orderDate;
	private int quantity;
	private double totalPrice;
	private String menuName;
	
	public OrderDTO(int orderID, int cafeId, int menuID, Date orderDate, int quantity, double totalPrice, String menuName) {
		this.orderID = orderID;
		this.cafeID = cafeID;
		this.menuID = menuID;
		this.orderDate = orderDate;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.menuName = menuName;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public void setCafeID(int cafeID) {
		this.cafeID = cafeID;
	}

	public void setMenuID(int menuID) {
		this.menuID = menuID;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getOrderID() {
		return orderID;
	}

	public int getCafeID() {
		return cafeID;
	}

	public int getMenuID() {
		return menuID;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public String getMenuName() {
		return menuName;
	}
}
