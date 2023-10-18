package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class cafesExam {
	public static void main(String[] args) {
		selectCafes();
		//insertCafes();
		//updatePrice();
		//deleteCafes();
		oneCafe();
	}
	
	static void selectCafes() {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khcafe";
		String password = "khcafe";
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, userName, password);
			// PreparedStatement selectPs = con.prepareStatement(selectQuery);
			
			// 1. 모든 카페 목록 가져오기 Statement st1 = con.createStatement(); / ResultSet result1 = st1.executeQuery();
			String selectQuery = "SELECT * FROM cafes";
			Statement st1 = con.createStatement();		
			ResultSet rs1 = st1.executeQuery(selectQuery);
			
			// 2. 특정 카페의 메뉴 가져오기
			String selectSQL = "SELECT * FROM menu";
			Statement st2 = con.createStatement();
			ResultSet rs2 = st2.executeQuery(selectSQL);
			
			while(rs1.next()) {
				int cafeID = rs1.getInt("cafe_ID");
				String cafeName = rs1.getString("cname");
				String cAddress = rs1.getString("caddress");
				String phoneNum = rs1.getString("phone_number");
				String operatingHours = rs1.getString("operating_hours");
				
				System.out.println(cafeID + " | " + cafeName + " | " + cAddress + " | " + phoneNum + " | " + operatingHours);
			}
			st1.close();
			
			while(rs2.next()) {
				int menuID = rs2.getInt("menu_id");
				int cafeID = rs2.getInt("cafe_id");
				String menuName = rs2.getString("mname");
				double price = rs2.getDouble("price");
				String description = rs2.getString("description");
				
				System.out.println(menuID + " | " + cafeID + " | " + menuName + " | " + price + " | " + description);
				
			}
			
			rs2.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}		
	}
	
	static void insertCafes() { 	// 3. 새로운 카페 추가하기
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khcafe";
		String password = "khcafe";
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, userName, password);
			String insertSQL = "INSERT INTO cafes (cafe_id, cname, caddress, phone_number, operating_hours)"
					+ "VALUES ( ?, ?, ?, ?, ?)";
			PreparedStatement st3 = con.prepareStatement(insertSQL);
			
			st3.setInt(1, 32);
			st3.setString(2, "쌍화탕탕탕");
			st3.setString(3, "서울시 강남구 테헤란로");
			st3.setString(4, "016-001-0000");
			st3.setString(5, "주말: 9:00-12:00");
			
			int rowInsert = st3.executeUpdate();
			System.out.println(rowInsert + "행 추가");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	static void updatePrice() {	// 4. 특정 카페의 메뉴가격 변경
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khcafe";
		String password = "khcafe";
		
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, userName, password);
			String updateSQL = "UPDATE menu SET price = ? WHERE menu_id = ?";
			PreparedStatement updateMenu = con.prepareStatement(updateSQL);
			updateMenu.setDouble(1, 8.55);
			updateMenu.setInt(2, 16);
			
			int rowUpdateMenu = updateMenu.executeUpdate();
			System.out.println(rowUpdateMenu + "행 업데이트");
			updateMenu.close();
			
			// 5. 특정 카페의 정보 수정하기
			String updateSQL2 = "UPDATE cafes SET cname = ? WHERE cafe_id = ?";
			PreparedStatement updateCafe = con.prepareStatement(updateSQL2);
			updateCafe.setString(1, "동네카페");
			updateCafe.setInt(2, 31);
			
			int rowUpdateCafe = updateCafe.executeUpdate();
			System.out.println(rowUpdateCafe + "행 업데이트");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static void deleteCafes() { // 6. 특정 카페의 정보 삭제하기
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khcafe";
		String password = "khcafe";
		
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, userName, password);
			String deleteSQL = "DELETE FROM cafes WHERE cafe_id = ?";
			PreparedStatement deletePs = con.prepareStatement(deleteSQL);
			deletePs.setInt(1, 32);
			
			int rowsUpdate = deletePs.executeUpdate();
			System.out.println(rowsUpdate + " 삭제 되었습니다.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void oneCafe() { // 7. 특정 카페의 메뉴 수 가져오기 while문 활용
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khcafe";
		String password = "khcafe";
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, userName, password);
			String selectSQL1 = "SELECT * FROM menu WHERE cafe_id = ?";
			PreparedStatement selectPs1 = con.prepareStatement(selectSQL1);
			
			int targetID = 7;
			selectPs1.setInt(1, targetID);
			
			ResultSet result1 = selectPs1.executeQuery();
			
			if (!result1.isBeforeFirst()) {
				System.out.println("데이터 없음");
			}
			while (result1.next()) {
				int menuID = result1.getInt("menu_id");
				int cafeID = result1.getInt("cafe_id");
				String menuName = result1.getString("mname");
				double price = result1.getDouble("price");
				String description = result1.getString("description");
				System.out.println(menuID + " | " + cafeID + " | " + menuName + " | " + price + " | " + description);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	static void priceRange() { 	// 8. 특정 가격 범위 내의 모든 메뉴 가져오기
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khcafe";
		String password = "khcafe";
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, userName, password);
			String selectRange = "SELECT * FROM menu WHERE price 1.00 AND 2.00";
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
