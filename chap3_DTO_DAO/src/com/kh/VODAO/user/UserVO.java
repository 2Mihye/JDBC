package com.kh.VODAO.user;

import java.util.Date;

public class UserVO {
	private int userID; // 사용자 아이디
	private String userName; // 사용자 이름
	private String email; // 사용자 이메일
	private Date regDate; // 동록 날짜
	
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
}
