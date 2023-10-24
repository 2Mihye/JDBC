package com.kh.MVC.Orders;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO { // DataBase 연결 후 select 작성
	private Connection connection;
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String userName = "khcafe";
	String password = "khcafe";
	
	public OrderDAO() {
		try {
			connection = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<OrderDTO> getAllOrders(){
		List<OrderDTO> orders = new ArrayList<>();
		
		try {
			PreparedStatement ps =  connection.prepareStatement("SELECT * FROM OLDORDERS");
			ResultSet result = ps.executeQuery();
			
			while(result.next()) {
				int orderID = result.getInt("order_id");
				int cafeID = result.getInt("cafe_id");
				int menuID = result.getInt("menu_id");
				Date orderDate = result.getDate("order_date");
				int quantity = result.getInt("quantity");
				double totalPrice = result.getDouble("total_price");
				String menuName = result.getString("oname");
				
				OrderDTO order = new OrderDTO(orderID, cafeID, menuID, orderDate, quantity, totalPrice, menuName);
				orders.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}
}
