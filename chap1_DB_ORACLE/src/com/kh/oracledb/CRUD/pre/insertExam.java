package com.kh.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertExam {
	// insert 작성해서 cafes 테이블에 여러 카페 추가하기
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khcafe";
		String password = "khcafe";
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, userName, password);
			String insertSQL = "INSERT INTO cafes (cafe_id, cname, caddress, phone_number, operating_hours)"
					+ "VALUES (?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(insertSQL);
			
			insertCafes(ps, 21, "미주카페", "귀염시 까칠구 동생동", "010-001-0000", "매일: 13:00-19:30");
			insertCafes(ps, 22, "엄마찻집", "푸근시 딸랑구 엄마동", "016-000-0000", "매일: 09:00-18:00");

			int rowsInsert = ps.executeUpdate();
			System.out.println(rowsInsert + "행 삽입 완료");
			
			ps.close();		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	static void insertCafes (PreparedStatement ps, int cafe_id, String cname, String caddress, String phone_number, String operating_hours) throws SQLException {
		ps.setInt(1, cafe_id);
		ps.setString(2, cname);
		ps.setString(3, caddress);
		ps.setString(4, phone_number);
		ps.setString(5, operating_hours);
		ps.executeUpdate();		
	}

}
