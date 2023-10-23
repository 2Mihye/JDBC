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
	public boolean createUser(UserVO user/*파라미터 값 추가*/) {
		String sql = "INSERT INTO userinfo (user_id, user_name, email, reg_date)"
				+ "VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, user.getUserID());
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getEmail());
			ps.setDate(4, new Date(user.getRegDate().getTime()));
			 
			int rows = ps.executeUpdate();
			return rows > 0; // 값이 들어오면 0보다 커지므로 true가 됨;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<UserVO> getAllUsers() throws SQLException {
		List<UserVO> users = new ArrayList<>();
		String query = "SELECT * FROM userinfo";
		// try - with - resource : 메모리를 상대적으로 적게 쓰면서 데이터베이스 resource를 안전하게 사용하고 닫아주기 위해 사용되는 방법
		try(PreparedStatement ps = connection.prepareStatement(query);){
	
			ResultSet result = ps.executeQuery();
			// selectOne = If문 // selectAll = while문 (무조건 적인 것은 아니고 주로 이렇게 씀)
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
