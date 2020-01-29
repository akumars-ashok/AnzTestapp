package com.example.anz.main.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="accounts")
public class AccountsEntity {
	
	@Id
	@GeneratedValue
	private int accountNumber;
	
	private String accountName;
	
	private String accountType;
	
	private Date balanceDate;
	
	private String currency;
	
	private double openingAvailableBalance;

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Date getBalanceDate() {
		return balanceDate;
	}

	public void setBalanceDate(Date balanceDate) {
		this.balanceDate = balanceDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getOpeningAvailableBalance() {
		return openingAvailableBalance;
	}

	public void setOpeningAvailableBalance(double openingAvailableBalance) {
		this.openingAvailableBalance = openingAvailableBalance;
	}
	
	

}
