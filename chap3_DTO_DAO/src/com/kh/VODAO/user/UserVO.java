package com.kh.VODAO.user;

import java.util.Date;

public class UserVO {
	private int userID; // ����� ���̵�
	private String userName; // ����� �̸�
	private String email; // ����� �̸���
	private Date regDate; // ���� ��¥
	
	
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
