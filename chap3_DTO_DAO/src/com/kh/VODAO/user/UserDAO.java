package com.kh.VODAO.user;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDAO {
	private Connection connection;
	
	public UserDAO(Connection connection ) {
		this.connection = connection;
	}
	public boolean createUser(UserVO user/*�Ķ���� �� �߰�*/) {
		String sql = "INSERT INTO userinfo (user_id, user_name, email, reg_date)"
				+ "VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, user.getUserID());
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getEmail());
			ps.setDate(4, new Date(user.getRegDate().getTime()));
			 
			int rows = ps.executeUpdate();
			return rows > 0; // ���� ������ 0���� Ŀ���Ƿ� true�� ��;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<UserVO> getAllUsers() throws SQLException {
		List<UserVO> users = new ArrayList<>();
		String query = "SELECT * FROM userinfo";
		// try - with - resource : �޸𸮸� ��������� ���� ���鼭 �����ͺ��̽� resource�� �����ϰ� ����ϰ� �ݾ��ֱ� ���� ���Ǵ� ���
		try(PreparedStatement ps = connection.prepareStatement(query);){
	
			ResultSet result = ps.executeQuery();
			// selectOne = If�� // selectAll = while�� (������ ���� ���� �ƴϰ� �ַ� �̷��� ��)
			while(result.next()) {
				UserVO user = new UserVO();
				user.setUserID(result.getInt("user_id"));
				user.setUserName(result.getString("user_name"));
				user.setEmail(result.getString("email"));
				user.setRegDate(result.getDate("reg_date"));
				users.add(user);
			}
		}
		return users;
	}
}
