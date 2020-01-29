package com.example.anz.main.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.NoTransactionException;

import com.example.anz.main.dto.AccountsDTO;
import com.example.anz.main.dto.TransactionDTO;
import com.example.anz.main.model.AccountsEntity;
import com.example.anz.main.model.TransactionEntity;
import com.example.anz.main.repository.AccountsRepository;
import com.example.anz.main.repository.TransactionRepository;

import exception.NoAccountsExceptionFound;
import exception.NoTransactionHistoryException;


@Service
public class AccountService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public static final String NO_TRNSACTION_DONE="TRANSACTION HISTORY NOT FOUND";
	public static final String EMPTY_ACCOUNTS="ACCOUNT DETAILS NOT FOUND";
	
	@Autowired
	private AccountsRepository accountsRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	public List<AccountsDTO> getAllAccounts() throws NoAccountsExceptionFound{
		
		logger.info("fetching Accounts details ..");
		List<AccountsEntity> accountLists=accountsRepository.findAll();
		List<AccountsDTO> accountDTOs=new ArrayList<AccountsDTO>();
		
		if(accountLists.isEmpty()) {
			throw new NoAccountsExceptionFound(EMPTY_ACCOUNTS);
		}
		
		for(AccountsEntity accountsEntity: accountLists) {
			AccountsDTO accountsDTO= AccountsDTO.valueOf(accountsEntity);
			accountDTOs.add(accountsDTO);
		}
		
		logger.info("Account details : {}", accountDTOs);
		return accountDTOs;
	}
	
	public List<TransactionDTO> getTransByAccountNumber(int accountNumber) throws NoTransactionHistoryException{
		
		logger.info("Transaction details request for customer {}", accountNumber);
		List<TransactionDTO> transactionDTOs=new ArrayList<TransactionDTO>();
		List<TransactionEntity> transactionHistorylist=transactionRepository.findByAccountNumber(accountNumber);
		
		
		if(transactionHistorylist.isEmpty()) {
			throw new NoTransactionHistoryException(NO_TRNSACTION_DONE);
		}
		
		for(TransactionEntity transactionEntity: transactionHistorylist) {
			TransactionDTO transactionDTO=TransactionDTO.valueOf(transactionEntity);
			transactionDTOs.add(transactionDTO);
		}
		
		logger.info("Transaction details : {}", transactionDTOs);
		return transactionDTOs;
	}

}
