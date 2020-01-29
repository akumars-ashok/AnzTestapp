package com.example.anz.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.anz.main.dto.AccountsDTO;
import com.example.anz.main.dto.TransactionDTO;
import com.example.anz.main.service.AccountService;

import exception.NoAccountsExceptionFound;
import exception.NoTransactionHistoryException;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	//fetch all accounts list
	//@RequestMapping(value = "/getAllAccounts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AccountsDTO>> getAllAccounts() throws NoAccountsExceptionFound{
		List<AccountsDTO> accountList= accountService.getAllAccounts();
		return new ResponseEntity<List<AccountsDTO>>(accountList, new HttpHeaders(), HttpStatus.OK);
	}
     
	//fetch transaction history by account number
	@RequestMapping(value = "/{accountNumber}")
	public ResponseEntity<List<TransactionDTO>> getTransHistorybyAccNumber(@PathVariable("accountNumber") Integer accountNumber) throws NoTransactionHistoryException{
		List<TransactionDTO> transactionList=accountService.getTransByAccountNumber(accountNumber);
		return new ResponseEntity<List<TransactionDTO>>(transactionList, new HttpHeaders(), HttpStatus.OK);
	}
}
