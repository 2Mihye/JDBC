package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class selectSample {

	public static void main(String[] args) {
		// 코드가 부적합하다라는 오류가 뜨게되면 무조건 코드가 잘못된 것이므로 코드를 다시 확인할 것 !
		//selectAll();
		//selectOne();
		//selectIf();
		//selectChoon();
		
	}
	
	static void selectAll() {
		// 1. 드라이버 연결 : 오라클 JDBC 드라이버 클래스 이름
		String driver = "oracle.jdbc.driver.OracleDriver";
		// 2. 오라클 내 컴퓨터 연결 : 데이터베이스 연결 정보
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // String url = "jdbc:oracle:thin:@localhost(본인의IP주소):port번호:xe";
		// 3. 오라클 로그인을 위한 유저명과 비밀번호 입력
		String user = "KHBANK";
		String password = "KHBANK";
		
		Connection con = null;
		try {
			// 연결을 사용하여 쿼리 실행 또는 데이터베이스 작업 수행
			con = DriverManager.getConnection(url, user, password);
			System.out.println("데이터베이스 연결 성공 !");
			
			// SELECT 쿼리
			String selectQuery = "SELECT * FROM BANK";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			ResultSet result = selectState .executeQuery();
			
			// result.next() : result객체에서 다음 행(row)으로 이동. 다음 행이 있으면 true를 반환, 그렇지 않으면 false반환
			while(result.next()) {
				int accountID = result.getInt("account_id"); // KHBANK에 있는 bank테이블 결과 집합에서 account_id를 가져옴
				String accountName = result.getString("account_name");
				Double balance = result.getDouble("balance");
				// accountNumber, branchName, lastTransactionDate(import java.sql.Date // Date lastTransactionDate) 추가하기
				int accountNumber = result.getInt("account_number");
				String branchName = result.getString("branch_name");
				Date lastTransactionDate = result.getDate("last_transaction_date");
				System.out.println("ACCOUNT_ID : " + accountID + "/ Name : " + accountName + "/ ACCOUNT_NUMBER : "
				+ accountNumber + "/ BRANCH_NAME : " + branchName + "/ BALANCE : " + balance + "/ LAST_TRANSACTION_DATE : "
				+ lastTransactionDate);
				//System.out.println("ACCOUNT_NAME : " + accountName);
				//System.out.println("BALANCE : " + balance);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void selectOne() { // select * from menu 작성해서 menu table 가져오기
		// 1. 드라이버 연결 : 오라클 JDBC 드라이버 클래스 이름
				String driver = "oracle.jdbc.driver.OracleDriver";
				// 2. 오라클 내 컴퓨터 연결 : 데이터베이스 연결 정보
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				
				// 3. 오라클 로그인을 위한 유저명과 비밀번호 입력
				String user = "khcafe";
				String password = "khcafe";
				
				Connection con = null;
				try {
					// 연결을 사용하여 쿼리 실행 또는 데이터베이스 작업 수행
					con = DriverManager.getConnection(url, user, password);
					System.out.println("데이터베이스 연결 성공 !");
					
					// SELECT 쿼리
					String selectQuery = "SELECT * FROM MENU";
					PreparedStatement selectState = con.prepareStatement(selectQuery);
					ResultSet result = selectState .executeQuery();
					
					while (result.next()) {
						int menuID = result.getInt("MENU_ID");
						int cafeID = result.getInt("CAFE_ID");
						String menuName = result.getString("mname");
						double price = result.getDouble("price");
						String description = result.getString("description");
						
						System.out.println("Menu ID : " + menuID +"| Cafe ID : " + cafeID + "| Menu Name : " + menuName
						+ "| Price : " + price + "| Description : " + description);
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		
	}

	static void selectIf() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "KHBANK";
		String password = "KHBANK";
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, user, password);
			// where절 사용하여 조건절 추가
			String selectQuery = "SELECT * FROM BANK WHERE account_number in (?,?)";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			
			/*
			// 여기에 원하는 조건의 account_id 설정
			int targetAID = 2;
			
			// 조건 설정
			selectState.setInt(1, targetAID);
			ResultSet result = selectState.executeQuery();
			*/
			 
			String[] targetAN = {"1234567890","5555666777"};
			selectState.setString(1, targetAN[0]);
			selectState.setString(2, targetAN[1]);
			ResultSet result = selectState.executeQuery();
			
			// 값 존재 여부
			if (!result.isBeforeFirst()) {
				System.out.println("데이터 없음");
			}
			while (result.next()) {
				int a = result.getInt("account_id");
				String b = result.getString("account_number");
				String c = result.getString("account_name");
				double d = result.getDouble("balance");
				String e = result.getString("branch_name");
				Date f = result.getDate("last_transaction_date");
				System.out.println("Account_ID : " + a + " | Account_No : " + b + " | Account_Name : " + c
						+ " | Balance : " + d + " | Branch_Name : " + e + " | Last_Transaction_Date : " + f);
			}
			 
			/*if문
			
			if (result.next()) {
				int a = result.getInt("account_id");
				String b = result.getString("account_number");
				String c = result.getString("account_name");
				double d = result.getDouble("balance");
				String e = result.getString("branch_name");
				Date f = result.getDate("last_transaction_date");
				System.out.println("Account_ID : " + a + " | Account_No : " + b + " | Account_Name : " + c
						+ " | Balance : " + d + "Branch_Name : " + e + " | Last_Transaction_Date : " + f);
			} else {
				System.out.println("조건에 해당하는 데이터가 없습니다.");
			}*/
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	static void selectChoon() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "homework";
		String password = "homework";
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			String selectQuery = "SELECT * FROM tb_student WHERE student_no = ?";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			
			String targetSNo = "A213046";
			selectState.setString(1, targetSNo);
			ResultSet result = selectState.executeQuery();
			
			while(result.next()) {
				String studentNo = result.getString("student_no");
				int departmentNo = result.getInt("department_no");
				String studentName = result.getString("student_name");
				String studentSSN = result.getString("student_SSN");
				String studentAddress = result.getString("student_address");
				Date entranceDate = result.getDate("entrance_date");
				String absenceYN = result.getString("absence_YN");
				/*char[] charArray = absenceYN.toCharArray();
				for(char c : charArray) {
				}*/
				String coachNo = result.getString("coach_professor_no");
				
				System.out.println("학번 : " + studentNo + " | 학과번호 : " + departmentNo + " | 이름 : " + studentName
						+ " | 주민번호 : " + studentSSN + " | 주소 : " + studentAddress + " | 입학일 : " + entranceDate
						+ " | 휴학여부(Y/N) : " + absenceYN + " | 지도교수 : " + coachNo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	static void selectKhcafe() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "khcafe";
		String password = "khcafe";
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			String selectQuery = "SELECT * FROM BOOK";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			int targetBID = 24;
			selectState.setInt(1, 24);
			ResultSet result = selectState.executeQuery();
			
			
			if(result.next()) {
				int bookID = result.getInt("book_id");
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}