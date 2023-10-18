package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class insertSample {

	public static void main(String[] args) {
		// �ڵ尡 �������ϴٶ�� ������ �߰ԵǸ� ������ �ڵ尡 �߸��� ���̹Ƿ� �ڵ带 �ٽ� Ȯ���� �� !
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
			insertState.setString(3, "�̹���");
			insertState.setDouble(4, 1500.00);
			insertState.setString(5, "KH");
			insertState.setDate(6, Date.valueOf("2023-10-16"));
			
			int rowsInsert = insertState.executeUpdate();
			System.out.println(rowsInsert + "row(��) �߰�");
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
			insertState.setString(2, "�����ٹ�");
			insertState.setString(3, "����� õ�籸 õ��� 77-7");
			insertState.setString(4, "010-000-0000");
			insertState.setString(5, "����: 09:00-20:00");
			
			int rowsInsert = insertState.executeUpdate();
			System.out.println(rowsInsert + "�� �߰�");
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
			insertState.setString(2, "���");
			insertState.setString(3, "���Ͽ� ����");
			insertState.setInt(4, 1973);
			insertState.setString(5, "978-3522119401");
			insertState.setString(6, "Fantasy");
			insertState.setString(7, "�ð����ϰ� ����鿡�� ���ѱ� �ð��� ������ �� ������ �̻��� �̾߱�");
			insertState.setDouble(8, 13.50);
			insertState.setDate(9, Date.valueOf("1973-02-09"));
			insertState.setDate(10, Date.valueOf("2023-10-18"));
			insertState.setDate(11, null);
			insertState.setString(12, "N");
			
			int rowsInsert = insertState.executeUpdate();
			System.out.println(rowsInsert + "�� �߰�");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}