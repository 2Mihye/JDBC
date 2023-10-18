package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class selectSample {

	public static void main(String[] args) {
		// �ڵ尡 �������ϴٶ�� ������ �߰ԵǸ� ������ �ڵ尡 �߸��� ���̹Ƿ� �ڵ带 �ٽ� Ȯ���� �� !
		//selectAll();
		//selectOne();
		//selectIf();
		//selectChoon();
		
	}
	
	static void selectAll() {
		// 1. ����̹� ���� : ����Ŭ JDBC ����̹� Ŭ���� �̸�
		String driver = "oracle.jdbc.driver.OracleDriver";
		// 2. ����Ŭ �� ��ǻ�� ���� : �����ͺ��̽� ���� ����
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // String url = "jdbc:oracle:thin:@localhost(������IP�ּ�):port��ȣ:xe";
		// 3. ����Ŭ �α����� ���� �������� ��й�ȣ �Է�
		String user = "KHBANK";
		String password = "KHBANK";
		
		Connection con = null;
		try {
			// ������ ����Ͽ� ���� ���� �Ǵ� �����ͺ��̽� �۾� ����
			con = DriverManager.getConnection(url, user, password);
			System.out.println("�����ͺ��̽� ���� ���� !");
			
			// SELECT ����
			String selectQuery = "SELECT * FROM BANK";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			ResultSet result = selectState .executeQuery();
			
			// result.next() : result��ü���� ���� ��(row)���� �̵�. ���� ���� ������ true�� ��ȯ, �׷��� ������ false��ȯ
			while(result.next()) {
				int accountID = result.getInt("account_id"); // KHBANK�� �ִ� bank���̺� ��� ���տ��� account_id�� ������
				String accountName = result.getString("account_name");
				Double balance = result.getDouble("balance");
				// accountNumber, branchName, lastTransactionDate(import java.sql.Date // Date lastTransactionDate) �߰��ϱ�
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

	static void selectOne() { // select * from menu �ۼ��ؼ� menu table ��������
		// 1. ����̹� ���� : ����Ŭ JDBC ����̹� Ŭ���� �̸�
				String driver = "oracle.jdbc.driver.OracleDriver";
				// 2. ����Ŭ �� ��ǻ�� ���� : �����ͺ��̽� ���� ����
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				
				// 3. ����Ŭ �α����� ���� �������� ��й�ȣ �Է�
				String user = "khcafe";
				String password = "khcafe";
				
				Connection con = null;
				try {
					// ������ ����Ͽ� ���� ���� �Ǵ� �����ͺ��̽� �۾� ����
					con = DriverManager.getConnection(url, user, password);
					System.out.println("�����ͺ��̽� ���� ���� !");
					
					// SELECT ����
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
			// where�� ����Ͽ� ������ �߰�
			String selectQuery = "SELECT * FROM BANK WHERE account_number in (?,?)";
			PreparedStatement selectState = con.prepareStatement(selectQuery);
			
			/*
			// ���⿡ ���ϴ� ������ account_id ����
			int targetAID = 2;
			
			// ���� ����
			selectState.setInt(1, targetAID);
			ResultSet result = selectState.executeQuery();
			*/
			 
			String[] targetAN = {"1234567890","5555666777"};
			selectState.setString(1, targetAN[0]);
			selectState.setString(2, targetAN[1]);
			ResultSet result = selectState.executeQuery();
			
			// �� ���� ����
			if (!result.isBeforeFirst()) {
				System.out.println("������ ����");
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
			 
			/*if��
			
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
				System.out.println("���ǿ� �ش��ϴ� �����Ͱ� �����ϴ�.");
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
				
				System.out.println("�й� : " + studentNo + " | �а���ȣ : " + departmentNo + " | �̸� : " + studentName
						+ " | �ֹι�ȣ : " + studentSSN + " | �ּ� : " + studentAddress + " | ������ : " + entranceDate
						+ " | ���п���(Y/N) : " + absenceYN + " | �������� : " + coachNo);
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