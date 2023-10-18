package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class insertSample {

	public static void main(String[] args) {
		// 코드가 부적합하다라는 오류가 뜨게되면 무조건 코드가 잘못된 것이므로 코드를 다시 확인할 것 !
		//insertOne();
		//insertKhCafe();
		insertKhcafe();
		
	}

	static void insertOne() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "KHBANK";
		String password = "KHBANK";
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String insertQuery = "INSERT INTO BANK (account_id, account_number, account_name, balance, branch_name, last_transaction_date)"
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement insertState = con.prepareStatement(insertQuery);
			insertState.setInt(1, 13);
			insertState.setString(2, "19950601");
			insertState.setString(3, "이미주");
			insertState.setDouble(4, 1500.00);
			insertState.setString(5, "KH");
			insertState.setDate(6, Date.valueOf("2023-10-16"));
			
			int rowsInsert = insertState.executeUpdate();
			System.out.println(rowsInsert + "row(행) 추가");
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	static void insertKhCafe() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "khcafe";
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String insertQuery = "INSERT INTO CAFES (cafe_id, cname, caddress, phone_number, operating_hours)"
					+ "VALUES (?, ?, ?, ?, ?)";
			PreparedStatement insertState = con.prepareStatement(insertQuery);
			insertState.setInt(1, 20);
			insertState.setString(2, "미혜다방");
			insertState.setString(3, "서울시 천당구 천사로 77-7");
			insertState.setString(4, "010-000-0000");
			insertState.setString(5, "매일: 09:00-20:00");
			
			int rowsInsert = insertState.executeUpdate();
			System.out.println(rowsInsert + "행 추가");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	static void insertKhcafe() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "khcafe";
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String insertQuery = "INSERT INTO BOOK(book_id, title, author, publication_year, ISBN, genre, description, price, publication_date, created_date, updated_date, is_available)"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement insertState = con.prepareStatement(insertQuery);
			insertState.setInt(1, 24);
			insertState.setString(2, "모모");
			insertState.setString(3, "미하엘 엔데");
			insertState.setInt(4, 1973);
			insertState.setString(5, "978-3522119401");
			insertState.setString(6, "Fantasy");
			insertState.setString(7, "시간도둑과 사람들에게 빼앗긴 시간을 돌려준 한 아이의 이상한 이야기");
			insertState.setDouble(8, 13.50);
			insertState.setDate(9, Date.valueOf("1973-02-09"));
			insertState.setDate(10, Date.valueOf("2023-10-18"));
			insertState.setDate(11, null);
			insertState.setString(12, "N");
			
			int rowsInsert = insertState.executeUpdate();
			System.out.println(rowsInsert + "행 추가");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}