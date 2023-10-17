package com.kh.db.oraclesample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class DBConnection {

	public static void main(String[] args) {
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
				// accountNumber, branchName, lastTransactionDate(java.sql import Date lastTransactionDate) �߰��ϱ�
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
		
		// �ڵ尡 �������ϴٶ�� ������ �߰ԵǸ� ������ �ڵ尡 �߸��� ���̹Ƿ� �ڵ带 �ٽ� Ȯ���� �� !
		
	}

}