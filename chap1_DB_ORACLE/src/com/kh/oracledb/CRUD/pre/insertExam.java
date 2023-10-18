package com.kh.oracledb.CRUD.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertExam {
	// insert �ۼ��ؼ� cafes ���̺� ���� ī�� �߰��ϱ�
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khcafe";
		String password = "khcafe";
		try {
			Connection con = DriverManager.getConnection(jdbcUrl, userName, password);
			String insertSQL = "INSERT INTO cafes (cafe_id, cname, caddress, phone_number, operating_hours)"
					+ "VALUES (?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(insertSQL);
			
			insertCafes(ps, 21, "����ī��", "�Ϳ��� ��ĥ�� ������", "010-001-0000", "����: 13:00-19:30");
			insertCafes(ps, 22, "��������", "Ǫ�ٽ� ������ ������", "016-000-0000", "����: 09:00-18:00");

			int rowsInsert = ps.executeUpdate();
			System.out.println(rowsInsert + "�� ���� �Ϸ�");
			
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
