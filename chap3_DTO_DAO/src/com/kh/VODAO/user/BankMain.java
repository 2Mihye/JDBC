package com.kh.VODAO.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BankMain { // 계좌 송금 (트랜잭션 추가)

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "KHBANK";
		String password = "KHBANK";
		try {
			Connection connection = DriverManager.getConnection(url, userName, password);
			Scanner sc = new Scanner(System.in);
			
			System.out.println("전송할 ID를 입력하세요.");
			int fromAccountID = sc.nextInt();
			
			System.out.println("전송받을 ID를 입력하세요.");
			int toAccountID = sc.nextInt();
			
			System.out.println("전송할 금액을 입력하세요.");
			double amount = sc.nextDouble();
			
			PreparedStatement ps = connection.prepareStatement("UPDATE bank SET balance = balance - ? WHERE account_id = ?");
			ps.setDouble(1, amount);
			ps.setInt(2, fromAccountID);
			ps.executeUpdate();
			connection.commit();
			
			PreparedStatement st = connection.prepareStatement("UPDATE bank SET balance = balance + ? WHERE account_id = ?");
			ps.setDouble(1, amount);
			ps.setInt(2, fromAccountID);
			ps.executeUpdate();
			connection.commit();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean checkBalance(int accountID) throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "KHBANK";
		String password = "KHBANK";
		Connection connection = DriverManager.getConnection(url, userName, password);
		
		String sql = "UPDATE bank SET balance = balance - ? WEHRE account_id = ?";
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, accountID);
		
		ResultSet result = ps.executeQuery();
		if(result.next()) {
			int id = result.getInt(1);
			return id > 0;
		}
		return false;
		
	}
	
	public void withdraw () {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "KHBANK";
		String password = "KHBANK";
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			String withdrawSQL = "UPDATE bank SET balance = balance - ? WEHRE account_id = ?";
			PreparedStatement ps = connection.prepareStatement(withdrawSQL);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
