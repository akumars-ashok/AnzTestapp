package com.example.anz.main.dto;

import java.sql.Date;

import com.example.anz.main.model.TransactionEntity;

public class TransactionDTO {
	
private int serialNumber;
	
	private int accountNumber;
	
	private String accountName;
	
	private Date ValueDate;
	
	private String currency;
	
	private double debitAmount;
	
	private double creditAmount;
	
	//Debit or credit type
	private String transactionType;
	
	private String transactionNarrative;

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

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

	public Date getValueDate() {
		return ValueDate;
	}

	public void setValueDate(Date valueDate) {
		ValueDate = valueDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(double debitAmount) {
		this.debitAmount = debitAmount;
	}

	public double getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(double creditAmount) {
		this.creditAmount = creditAmount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getTransactionNarrative() {
		return transactionNarrative;
	}

	public void setTransactionNarrative(String transactionNarrative) {
		this.transactionNarrative = transactionNarrative;
	}
	
	//convert entity into DTO
	public static TransactionDTO valueOf(TransactionEntity transactionHistory) {
		TransactionDTO transactionDTO=new TransactionDTO();
		transactionDTO.setAccountName(transactionHistory.getAccountName());
		transactionDTO.setAccountNumber(transactionHistory.getAccountNumber());
		transactionDTO.setCreditAmount(transactionHistory.getCreditAmount());
		transactionDTO.setDebitAmount(transactionHistory.getDebitAmount());
		transactionDTO.setCurrency(transactionHistory.getCurrency());
		transactionDTO.setTransactionType(transactionHistory.getTransactionType());
		transactionDTO.setValueDate(transactionHistory.getValueDate());
		transactionDTO.setTransactionNarrative(transactionHistory.getTransactionNarrative());
		return transactionDTO;
		
	}
	
	@Override
	public String toString() {
		return "TransactionDTO [accountId=" + accountNumber + ", accountName=" + accountName + ", TransactionType=" + transactionType
				+ ", currency=" + currency + ", debitAmmount=" +debitAmount + ", creditAmount=" + creditAmount+", valuedate="+ ValueDate + ", transactionNarrative ="+transactionNarrative+" ]";
	}
	

}
