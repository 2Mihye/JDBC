package com.kh.MVC.shopping;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserPay {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String userName = "KHBANK";
	String pasword = "KHBANK";
	
	ShoppingCart cart;
	
	// īƮ�� ���� ���� ������
	public UserPay(ShoppingCart cart) {
		this.cart = cart;
	}
	
	// ������ �޼��� ����
	public boolean payment() { // �� ������ �Ǿ����� �ƴ��� Ȯ���� �޼���
		Connection connection = null;
		double cartTotalPrice = cart.cartTotalPrice(); // īƮ �ȿ� ���� ���� �ݾ� �޼��� �߰��ϱ�
		
		try {
			connection = DriverManager.getConnection(url, userName, pasword);
			// ���� �ܾ� ��������
			String balanceUser = "SELECT balance FROM bank WHERE account_name = '�̹���'";
			PreparedStatement ps = connection.prepareStatement(balanceUser);
			ResultSet result = ps.executeQuery(); // SELECT���� �ַ� ���� insert ���� executeUpdate
			
			if(result.next()) {
				double balance = result.getDouble("balance");
				// ���� �ܾ��� ��ٱ��� �Ѿ׺��� ���ٸ�?
				if(balance < cartTotalPrice) {
					System.out.println("�ܾ��� �����մϴ�.");
					return false;
				}
				// �������ִ� �ܾ׿��� ��ٱ��� �Ѿ��� ����� ��
				double newBalance = balance -cartTotalPrice;
				
				// �ܾ� ������Ʈ�ϱ�
				String updateBalance = "UPDATE bank SET balance = ? WHERE account_name = '�̹���'";
				PreparedStatement upps = connection.prepareStatement(updateBalance);
				upps.setDouble(1, newBalance);
				upps.executeUpdate();
				
				System.out.println("���� �Ϸ� ! ���� �ܾ� : " + newBalance);
				return true;

			} else {
				System.out.println("���¸� ã�� �� �����ϴ�.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
}
