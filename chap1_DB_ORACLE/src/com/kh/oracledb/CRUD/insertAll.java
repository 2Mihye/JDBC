package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertAll {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khcafe";
		String password = "khcafe";
		
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, userName, password);
			String insertSQL = "INSERT INTO products( product_id, product_name, category, price, stock_quantity)"
					+ "VALUES(?, ?, ?, ?, ?)";
			
			PreparedStatement ps = con.prepareStatement(insertSQL);
			
			
			// "products"테이블에 데이터 삽입
			insertProduct(ps, 7, "노트북", "전자제품", 899.99, 10);
			insertProduct(ps, 8, "냉장고", "가전제품", 799.99, 20);
			insertProduct(ps, 9, "마우스", "휴대기기", 79.99, 33);
			
			ps.close();
			
			System.out.println("행 삽입 완료");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	static void insertProduct(PreparedStatement ps, int product_id, String product_name, String category, double price, int stock_quantity) throws SQLException {
		ps.setInt(1, product_id);
		ps.setString(2, product_name);
		ps.setString(3, category);
		ps.setDouble(4, price);
		ps.setInt(5, stock_quantity);
		ps.executeUpdate();
	}
}
