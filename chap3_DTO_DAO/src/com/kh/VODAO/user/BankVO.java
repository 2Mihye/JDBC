package com.kh.VODAO.user;

import java.util.Date;

public class BankVO {
	private int accountID;
	private int accountNum;
	private String accountName;
	private double balance;
	private String branchName;
	private Date lastTransactionDate;
	
	
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public void setLastTransactionDate(Date lastTransactionDate) {
		this.lastTransactionDate = lastTransactionDate;
	}
	public int getAccountID() {
		return accountID;
	}
	public int getAccountNum() {
		return accountNum;
	}
	public String getAccountName() {
		return accountName;
	}
	public double getBalance() {
		return balance;
	}
	public String getBranchName() {
		return branchName;
	}
	public Date getLastTransactionDate() {
		return lastTransactionDate;
	}
	
	
}
