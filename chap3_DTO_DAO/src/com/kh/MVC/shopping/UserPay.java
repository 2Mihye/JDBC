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
	
	// 카트를 담을 결제 생성자
	public UserPay(ShoppingCart cart) {
		this.cart = cart;
	}
	
	// 결제할 메서드 생성
	public boolean payment() { // 잘 결제가 되었는지 아닌지 확인할 메서드
		Connection connection = null;
		double cartTotalPrice = cart.cartTotalPrice(); // 카트 안에 최종 결제 금액 메서드 추가하기
		
		try {
			connection = DriverManager.getConnection(url, userName, pasword);
			// 계좌 잔액 가져오기
			String balanceUser = "SELECT balance FROM bank WHERE account_name = '이미주'";
			PreparedStatement ps = connection.prepareStatement(balanceUser);
			ResultSet result = ps.executeQuery(); // SELECT에서 주로 쓰고 insert 등은 executeUpdate
			
			if(result.next()) {
				double balance = result.getDouble("balance");
				// 만약 잔액이 장바구니 총액보다 적다면?
				if(balance < cartTotalPrice) {
					System.out.println("잔액이 부족합니다.");
					return false;
				}
				// 가지고있는 잔액에서 장바구니 총액을 빼줘야 함
				double newBalance = balance -cartTotalPrice;
				
				// 잔액 업데이트하기
				String updateBalance = "UPDATE bank SET balance = ? WHERE account_name = '이미주'";
				PreparedStatement upps = connection.prepareStatement(updateBalance);
				upps.setDouble(1, newBalance);
				upps.executeUpdate();
				
				System.out.println("결제 완료 ! 남은 잔액 : " + newBalance);
				return true;

			} else {
				System.out.println("계좌를 찾을 수 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
}
