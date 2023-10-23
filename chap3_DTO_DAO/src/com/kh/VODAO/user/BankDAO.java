package com.kh.VODAO.user;

import java.sql.Connection;

public class BankDAO {
	private Connection connection;
	
	public BankDAO(Connection connection) {
		this.connection = connection;
	}
	
}
