package chap2_MVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class cafeModel {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String userName = "khcafe";
	String password = "khcafe";
	
	public void insertCafe(String name, String address, String phoneNumber, String operatingHours) {
		
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			System.out.println("연결 성공 !");
			String sql = "INSERT INTO cafes (name, address, phone_number, operating_hours)"
						+ "VALUES ( ?, ?, ?, ?)";
			PreparedStatement insertPs = con.prepareStatement(sql);
			insertPs.setString(1, name);
			insertPs.setString(2, address);
			insertPs.setString(3, phoneNumber);
			insertPs.setString(4, operatingHours);
			insertPs.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	

	public void insertProduct(int productID, String productName, String category, double price, int quantity) {
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			String sql = "INSERT INTO products (product_id, product_name, category, price, stock_quantity)"
					+ "VALUES (?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, productID);
			ps.setString(2, productName);
			ps.setString(3, category);
			ps.setDouble(4, price);
			ps.setInt(5, quantity);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateMenu(String description, int menuID, int cafeID) {
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			String sql = "UPDATE menu SET description = ? WHERE menu_id = ? AND cafe_id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, description);
			st.setInt(2, menuID);
			st.setInt(3, cafeID);
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateCafe(String operatingHours, int cafeID) { // 카페 운영시간 수정하기
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			String sql = "UPDATE cafes SET operating_hours = ? WHERE cafe_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, operatingHours);
			ps.setInt(2, cafeID);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
	}

	public void deleteCafe(int cafeID) {
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			String sql = "DELETE FROM cafes WHERE cafe_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cafeID);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void deleteMenu(int menuID) {
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			String sql = "DELETE FROM menu WHERE menu_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, menuID);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteOrder(int orderID) {
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			String sql = "DELETE FROM orders WHERE order_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, orderID);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void deleteProduct(int productID) {
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			String sql = "DELETE FROM products WHERE product_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, productID);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


}