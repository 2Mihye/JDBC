package com.kh.oracledb.CRUD.pre;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class insertBook {

	public static void main(String[] args) {
		// tableBook();
		//Book();
		
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khcafe";
		String password = "khcafe";
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, userName, password);
			String insertSQL = "INSERT INTO book (book_id, title, author, publication_year, isbn, genre, description, price, publication_date, created_date, is_available)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement insertPs = con.prepareStatement(insertSQL);
			
			//insertBook (insertPs, "마틸다", "로알드 달", 1995, "978-0101010101", "Novel", "초등학생 마틸다의 초능력 발현?!", 12.99, Date.valueOf("1995-10-19"), Date.valueOf("2023-10-15"), null, "Y");
			insertPs.setInt(1, 27);
			insertPs.setString(2, "마틸다");
			insertPs.setString(3, "로알드 달");
			insertPs.setInt(4, 1995);
			insertPs.setString(5, "978-1010101010");
			insertPs.setString(6, "Novel");
			insertPs.setString(7, "초등학생 마틸다의 초능력을 이용한 통쾌한 복수극");
			insertPs.setDouble(8, 12.99);
			insertPs.setDate(9, Date.valueOf("1995-10-19"));
			insertPs.setDate(10, Date.valueOf("2023-10-15"));
			insertPs.setString(11, "N");
			insertPs.executeUpdate();
			
			int rowInsert = insertPs.executeUpdate();
			System.out.println(rowInsert + "행 업데이트");
			
			insertPs.close();
			con.close();
			
			String selectSQL ="SELECT * FROM BOOK WHERE book_id = ?";
			PreparedStatement selectPs = con.prepareStatement(selectSQL);
			selectPs.setInt(1, 25);
			
			ResultSet rs = selectPs.executeQuery();
			while(rs.next()) {
				int bookID = rs.getInt("book_id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				int pubYear = rs.getInt("publication_year");
				String isbn = rs.getString("ISBN");
				String genre = rs.getString("genre");
				String description = rs.getString("description");
				double price = rs.getDouble("price");
				Date pubDate = rs.getDate("publication_date");
				Date createdDate = rs.getDate("created_date");
				Date updatedDate = rs.getDate("updated_date");
				String isAvailable = rs.getString("is_available");
				
				System.out.println(bookID +" | " + title + " | " + author + " | " + pubYear + " | " + isbn + " | " + genre + " | " + description + " | " + price + " | " + pubDate + " | " + createdDate + " | " + updatedDate + " | " + isAvailable);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	static void Book() {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khcafe";
		String password = "khcafe";
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, userName, password);
			String insertSQL = "INSERT INTO book (title, author, publication_year, isbn, genre, description, price, pulication_date, created_date, updated_date, is_available)"
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(insertSQL);
			
			insertBook (ps, "마틸다", "로알드 달", 1995, "978-0101010101", "Novel", "초등학생 마틸다의 초능력 발현?!", 12.99, Date.valueOf("1995-10-19"), Date.valueOf("2023-10-15"), null, "Y");
			
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	static void tableBook() {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khcafe";
		String password = "khcafe";
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, userName, password);
			String insertSQL = "INSERT INTO BOOK(book_id, title, author, publication_year, ISBN, genre, description, price, publication_date, created_date, updated_date, is_available)"
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), TO_DATE(?, 'YYYY-MM-DD'), TO_DATE(?, 'YYYY-MM-DD'), ?)";
			PreparedStatement ps = con.prepareStatement(insertSQL);
			
			//insertBook (ps, 25, "감동적인 책", "백구", 1993, "978-0987654321", "Novel", "백구의 주인찾아 삼만리를 다룬 감동적인 책", 12.99, Date.valueOf("1993-02-09"), Date.valueOf("2023-10-16"), null, "Y");
			//insertBook (ps, "찰리와 초콜릿 공장", "로알드 달", 1993, "978-0011223344", "Novel", "가난한 아이 찰리의 한방 인생역전 스토리", 13.99, Date.valueOf("1995-06-01"), Date.valueOf("2023-10-17"), null, "Y");
			
			int rowsInsert = ps.executeUpdate();
			System.out.println(rowsInsert + "행 삽입 완료");
			
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void insertBook(PreparedStatement ps,int book_id, String title, String author, int publication_year,
			String isbn, String genre, String description, double price, Date publication_date, Date created_date,
			Date updated_date, String is_available) throws SQLException {
		ps.setInt(1, book_id);
		ps.setString(2, title);
		ps.setString(3, author);
		ps.setInt(4, publication_year);
		ps.setString(5, isbn);
		ps.setString(6, genre);
		ps.setString(7, description);
		ps.setDouble(8, price);
		ps.setDate(9, publication_date);
		ps.setDate(10, created_date);
		ps.setDate(11, updated_date);
		ps.setString(12, is_available);
		int rows = ps.executeUpdate();
		//if(rows )
		ps.executeUpdate();		
	}
}
