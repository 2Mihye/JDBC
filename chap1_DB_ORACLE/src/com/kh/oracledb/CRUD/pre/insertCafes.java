package com.kh.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertCafes {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khcafe";
		String password = "khcafe";
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, userName, password);
			String insertSQL = "INSERT INTO cafes (cafe_id, cname, caddress, phone_number, operating_hours)"
					+ "VALUES (?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(insertSQL);
			
			insertCafes(ps, 23, "하니 the 달달구리", "서울시 광진구 가을동", "010-9329-0000", "매일: 15:00-18:00");
			
			int rowInsert = ps.executeUpdate();
			System.out.println(rowInsert + "행 추가");
			
			ps.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	static void insertCafes(PreparedStatement ps, int cafe_id, String cname, String caddress, String phone_number, String operating_hours) throws SQLException {
		ps.setInt(1, cafe_id);
		ps.setString(2, cname);
		ps.setString(3, caddress);
		ps.setString(4, phone_number);
		ps.setString(5, operating_hours);
		
		ps.executeUpdate();
	}
}
