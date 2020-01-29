package com.example.anz.main.dto;

import java.sql.Date;

import com.example.anz.main.model.AccountsEntity;

public class AccountsDTO {
	
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
	
	//converts entity into DTO
	public static AccountsDTO valueOf(AccountsEntity account) {
		AccountsDTO accountsDTO=new AccountsDTO();
		accountsDTO.setAccountNumber(account.getAccountNumber());
		accountsDTO.setAccountName(account.getAccountName());
		accountsDTO.setAccountType(account.getAccountType());
		accountsDTO.setBalanceDate(account.getBalanceDate());
		accountsDTO.setCurrency(account.getCurrency());
		accountsDTO.setOpeningAvailableBalance(account.getOpeningAvailableBalance());
		return accountsDTO;
		
	}
	
	@Override
	public String toString() {
		return "AccountDTO [accountId=" + accountNumber + ", accountName=" + accountName + ", accountType=" + accountType
				+ ", currency=" + currency + ", balanceDate=" +balanceDate + ", balance=" + openingAvailableBalance+"]";
	}

}
