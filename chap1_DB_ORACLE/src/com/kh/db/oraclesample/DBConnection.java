package com.kh.db.oraclesample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class DBConnection {

	public static void main(String[] args) {
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
				// accountNumber, branchName, lastTransactionDate(java.sql import Date lastTransactionDate) 추가하기
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
		
		// 코드가 부적합하다라는 오류가 뜨게되면 무조건 코드가 잘못된 것이므로 코드를 다시 확인할 것 !
		
	}

}
