package com.kh.VODAO.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) {
		UserMain um = new UserMain();
		// um.selectAll();
		um.selectScanner();
		// um.insertRun();
		
	}
	
	public boolean checkEmail(String email/*id받는 파라미터 자리*/) throws SQLException {
		// 1. DB 연결 URL, USERNAME, PASSWORD
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassword = "khcafe";
			Connection connection = DriverManager.getConnection(url, dbUserName, dbPassword);
			
			// 2. sql 작성
			String sql = "SELECT COUNT(*) FROM userinfo WHERE email = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			
			// 3. if문 활용하여 Result.next();
			ResultSet result = ps.executeQuery();			
			if(result.next()) {
				int count = result.getInt(1);
				// 4. return > 0 : 1이상이면 일치하도록
				return count > 0; // 1 이상이면 true
			} else {
				
			}

		return false; // 일치하지 않을 때
	}
	
	public boolean checkID(int userID/*id받는 파라미터 자리*/) throws SQLException {
		// 1. DB 연결 URL, USERNAME, PASSWORD
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassword = "khcafe";
			Connection connection = DriverManager.getConnection(url, dbUserName, dbPassword);
			
			// 2. sql 작성
			String sql = "SELECT * FROM userinfo WHERE user_id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, userID);
			
			// 3. if문 활용하여 Result.next();
			ResultSet result = ps.executeQuery();			
			if(result.next()) {
				int id = result.getInt(1);
				// 4. return > 0 : 1이상이면 일치하도록
				return id > 0; // 1 이상이면 true
			} else {
				
			}

		return false; // 일치하지 않을 때
	}
	
	public void selectScanner() {
		// 1. DB 연결 URL, USERNAME, PASSWORD
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassword = "khcafe";
		
		try {
			Connection cc = DriverManager.getConnection(url, dbUserName, dbPassword);
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				System.out.println("User ID를 입력해주세요.");
				System.out.println("종료하고 싶다면 특수문자를 제외하고 [e]를 입력하세요.");
				String input = sc.nextLine();
				
				// 만약에 e를 입력했다면
				if("e".equalsIgnoreCase(input)) { // if("e" == input || "E" == input) => e값이 대문자이건 소문자이건 상관 없을 떄
					System.out.println("종료합니다.");
					break; // break;가 없으면 종료되지 않고 "종료합니다"만 출력됨.
				}
			//	System.out.println();
				System.out.println("User email을 입력해주세요.");
				String userEmail = sc.nextLine();
				
				
				int userID = Integer.parseInt(input);
				// String sql = "SELECT * FROM USERINFO WHERE user_id = ?"; => Select One if문
				String sql = "SELECT * FROM USERINFO WHERE user_id = ? AND EMAIL = ?";
				PreparedStatement ps = cc.prepareStatement(sql);
				ps.setInt(1, userID);
				ps.setString(2, userEmail);
				ResultSet result = ps.executeQuery();
				
				
				
				// selectOne
				if(result.next()) {
					System.out.println("UserID : " + result.getInt("user_id"));
					System.out.println("User Name : " + result.getString("user_name"));
					System.out.println("Email : " + result.getString("email"));
					System.out.println("Registration Date : " + result.getDate("reg_date"));
					System.out.println();
				}else {
					// boolean ID or Email 하나가 일치하지 않는 경우 처리
					// boolean idTrue = 아이디 일치하는지 확인하는 메서드(userID);
					// boolean emailTrue = 이메일 일치하는지 확인하는 메서드(userEmail);
					boolean idTrue = checkID(userID);
					boolean emailTrue = checkEmail(userEmail);
					
					if(!idTrue && emailTrue) {
						System.out.println("일치하지 않는 User ID 입니다.");
						System.out.println();
					} else if(idTrue && !emailTrue) {
						System.out.println("일치하지 않는 User Email 입니다.");
						System.out.println();
					} else {
					System.out.println("일치하는 User ID와 email을 찾을 수 없습니다.");
					System.out.println();
					}
				}		
			}
			
		} catch (SQLException e) {
			e.printStackTrace();                
		}
		
	}
	
	public void selectAll() {
		// 1. DB 연결 URL, USERNAME, PASSWORD
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassword = "khcafe";
		
		try {
			Connection connection = DriverManager.getConnection(url, dbUserName, dbPassword);
			UserDAO userDAO = new UserDAO(connection);
			List<UserVO> users = userDAO.getAllUsers();
			for(UserVO u : users) {
				System.out.println("User ID : " + u.getUserID());
				System.out.println("User Name : " + u.getUserName());
				System.out.println("Email : " + u.getEmail());
				System.out.println("Reg Date : " + u.getRegDate());
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void insertRun() {
		// 1. DB 연결 URL, USERNAME, PASSWORD
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassword = "khcafe";		
		try {
			Connection connection = DriverManager.getConnection(url, dbUserName, dbPassword);
			UserDAO userDao = new UserDAO(connection);
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("User ID : ");
			int userID = sc.nextInt();
			
			System.out.print("아이디를 입력해주세요 : ");
			String userName = sc.next();
			
			System.out.print("회원가입이 거의 다 끝났습니다.");
			System.out.print("마지막으로 이메일 작성해주세요. : ");
			String email = sc.next();
			
			Date regDate = new Date(); // 얘는 java.util import // 현재 날짜와 시간을 사용한다는 의미
			// DB에 담기위해 인스턴스 생성 후 작성받은 정보 저장하기
			UserVO newUser = new UserVO();
			newUser.setUserID(userID);
			newUser.setUserName(userName);
			newUser.setEmail(email);
			newUser.setRegDate(regDate);
			
			// 데이터가 정상적으로 들어갔는지 boolean으로 확인
			if(userDao.createUser(newUser)) {
				System.out.println("유저가 성공적으로 등록되었습니다.");
			} else {
				System.out.println("유저 등록에 실패하였습니다.");
			}
			
			// 연결 닫기
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
