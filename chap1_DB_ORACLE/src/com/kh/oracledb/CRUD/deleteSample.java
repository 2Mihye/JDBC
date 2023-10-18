package com.kh.oracledb.CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class deleteSample {

	public static void main(String[] args) {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "KHBANK";
		String password = "KHBANK";
		
		// update ù ��° ���
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, userName, password);
			String deleteQuery = "DELETE FROM BANK WHERE account_id = ?";
			PreparedStatement deletePs = con.prepareStatement(deleteQuery);
			deletePs.setInt(1, 2);
			
			int rowsUpdate = deletePs.executeUpdate();
			System.out.println(rowsUpdate + " ���� �Ǿ����ϴ�.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
