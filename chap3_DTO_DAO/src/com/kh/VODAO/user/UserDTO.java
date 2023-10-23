package com.kh.VODAO.user;

import java.sql.Date;

public class UserDTO {
	private int userID;
	private String userName;
	private String email;
	private Date regDate;
	
	public UserDTO() {
	}
	
	public UserDTO(int userID, String userName, String email, Date regDate) {
		this.userID = userID;
		this.userName = userName;
		this.email = email;
		this.regDate = regDate;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getUserID() {
		return userID;
	}

	public String getUserName() {
		return userName;
	}

	public String getEmail() {
		return email;
	}

	public Date getRegDate() {
		return regDate;
	}
	
	@Override
	public String toString() {
		return "UserDTO";
	}
	
}
