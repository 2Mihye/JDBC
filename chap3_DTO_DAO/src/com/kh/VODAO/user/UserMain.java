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
	
	public boolean checkEmail(String email/*id�޴� �Ķ���� �ڸ�*/) throws SQLException {
		// 1. DB ���� URL, USERNAME, PASSWORD
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassword = "khcafe";
			Connection connection = DriverManager.getConnection(url, dbUserName, dbPassword);
			
			// 2. sql �ۼ�
			String sql = "SELECT COUNT(*) FROM userinfo WHERE email = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			
			// 3. if�� Ȱ���Ͽ� Result.next();
			ResultSet result = ps.executeQuery();			
			if(result.next()) {
				int count = result.getInt(1);
				// 4. return > 0 : 1�̻��̸� ��ġ�ϵ���
				return count > 0; // 1 �̻��̸� true
			} else {
				
			}

		return false; // ��ġ���� ���� ��
	}
	
	public boolean checkID(int userID/*id�޴� �Ķ���� �ڸ�*/) throws SQLException {
		// 1. DB ���� URL, USERNAME, PASSWORD
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassword = "khcafe";
			Connection connection = DriverManager.getConnection(url, dbUserName, dbPassword);
			
			// 2. sql �ۼ�
			String sql = "SELECT * FROM userinfo WHERE user_id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, userID);
			
			// 3. if�� Ȱ���Ͽ� Result.next();
			ResultSet result = ps.executeQuery();			
			if(result.next()) {
				int id = result.getInt(1);
				// 4. return > 0 : 1�̻��̸� ��ġ�ϵ���
				return id > 0; // 1 �̻��̸� true
			} else {
				
			}

		return false; // ��ġ���� ���� ��
	}
	
	public void selectScanner() {
		// 1. DB ���� URL, USERNAME, PASSWORD
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassword = "khcafe";
		
		try {
			Connection cc = DriverManager.getConnection(url, dbUserName, dbPassword);
			Scanner sc = new Scanner(System.in);
			
			while(true) {
				System.out.println("User ID�� �Է����ּ���.");
				System.out.println("�����ϰ� �ʹٸ� Ư�����ڸ� �����ϰ� [e]�� �Է��ϼ���.");
				String input = sc.nextLine();
				
				// ���࿡ e�� �Է��ߴٸ�
				if("e".equalsIgnoreCase(input)) { // if("e" == input || "E" == input) => e���� �빮���̰� �ҹ����̰� ��� ���� ��
					System.out.println("�����մϴ�.");
					break; // break;�� ������ ������� �ʰ� "�����մϴ�"�� ��µ�.
				}
			//	System.out.println();
				System.out.println("User email�� �Է����ּ���.");
				String userEmail = sc.nextLine();
				
				
				int userID = Integer.parseInt(input);
				// String sql = "SELECT * FROM USERINFO WHERE user_id = ?"; => Select One if��
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
					// boolean ID or Email �ϳ��� ��ġ���� �ʴ� ��� ó��
					// boolean idTrue = ���̵� ��ġ�ϴ��� Ȯ���ϴ� �޼���(userID);
					// boolean emailTrue = �̸��� ��ġ�ϴ��� Ȯ���ϴ� �޼���(userEmail);
					boolean idTrue = checkID(userID);
					boolean emailTrue = checkEmail(userEmail);
					
					if(!idTrue && emailTrue) {
						System.out.println("��ġ���� �ʴ� User ID �Դϴ�.");
						System.out.println();
					} else if(idTrue && !emailTrue) {
						System.out.println("��ġ���� �ʴ� User Email �Դϴ�.");
						System.out.println();
					} else {
					System.out.println("��ġ�ϴ� User ID�� email�� ã�� �� �����ϴ�.");
					System.out.println();
					}
				}		
			}
			
		} catch (SQLException e) {
			e.printStackTrace();                
		}
		
	}
	
	public void selectAll() {
		// 1. DB ���� URL, USERNAME, PASSWORD
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
		// 1. DB ���� URL, USERNAME, PASSWORD
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbUserName = "khcafe";
		String dbPassword = "khcafe";		
		try {
			Connection connection = DriverManager.getConnection(url, dbUserName, dbPassword);
			UserDAO userDao = new UserDAO(connection);
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("User ID : ");
			int userID = sc.nextInt();
			
			System.out.print("���̵� �Է����ּ��� : ");
			String userName = sc.next();
			
			System.out.print("ȸ�������� ���� �� �������ϴ�.");
			System.out.print("���������� �̸��� �ۼ����ּ���. : ");
			String email = sc.next();
			
			Date regDate = new Date(); // ��� java.util import // ���� ��¥�� �ð��� ����Ѵٴ� �ǹ�
			// DB�� ������� �ν��Ͻ� ���� �� �ۼ����� ���� �����ϱ�
			UserVO newUser = new UserVO();
			newUser.setUserID(userID);
			newUser.setUserName(userName);
			newUser.setEmail(email);
			newUser.setRegDate(regDate);
			
			// �����Ͱ� ���������� ������ boolean���� Ȯ��
			if(userDao.createUser(newUser)) {
				System.out.println("������ ���������� ��ϵǾ����ϴ�.");
			} else {
				System.out.println("���� ��Ͽ� �����Ͽ����ϴ�.");
			}
			
			// ���� �ݱ�
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
