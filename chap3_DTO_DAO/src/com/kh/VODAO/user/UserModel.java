package com.kh.VODAO.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserModel {
	private Connection connection;
	
	public UserModel(Connection connection) {
		this.connection = connection;
	}
	
	public List<UserDTO> getUsers(){
		List<UserDTO> users = new ArrayList<>();
		String query = "SELECT * FROM userinfo";
		try {
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet result = ps.executeQuery();
			while(result.next()) {
				UserDTO user = new UserDTO();
				user.setUserID(result.getInt("user_id"));
				user.setUserName(result.getString("user_name"));
				user.setEmail(result.getString("email"));
				user.setRegDate(result.getDate("reg_date"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
}
