package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updateSample {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "KHBANK";
		String password = "KHBANK";
		
		// update ù ��° ���
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, userName, password);
			String updateQuery = "UPDATE BANK SET balance = ? WHERE account_number = ?";
			PreparedStatement updatePs = con.prepareStatement(updateQuery);
			updatePs.setDouble(1, 2000.00);
			updatePs.setString(2, "1234567890");
			
			int rowsUpdate = updatePs.executeUpdate();
			System.out.println(rowsUpdate + " ������Ʈ �Ǿ����ϴ�.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
