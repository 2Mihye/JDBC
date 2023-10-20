package com.kh.dtoSample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CafeMain {

	public static void main(String[] args) {
		// Connection�� ������ ���� �ۼ� (url, username, password
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "khcafe";
		String password = "khcafe";
		try {
			Connection con = DriverManager.getConnection(url, userName, password);
			//�ν��Ͻ� �����Ͽ� �� �ʱ�ȭ
			CafeView view = new CafeView();
			
			// �ν��Ͻ� �����Ͽ� ��Ʈ�ѷ� �ʱ�ȭ
			CafeController controller = new CafeController(con, view);
			
			// ī�� ���� ǥ���ϴ� �޼��� ��������
			controller.displayAllCafes();
			
			// connection.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
