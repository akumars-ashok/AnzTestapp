package com.example.anz.service;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import org.mockito.stubbing.OngoingStubbing;
import org.springframework.test.context.ContextConfiguration;

import com.example.anz.main.dto.AccountsDTO;
import com.example.anz.main.dto.TransactionDTO;
import com.example.anz.main.model.AccountsEntity;
import com.example.anz.main.model.TransactionEntity;
import com.example.anz.main.repository.AccountsRepository;
import com.example.anz.main.repository.TransactionRepository;
import com.example.anz.main.service.AccountService;

import exception.NoAccountsExceptionFound;
import exception.NoTransactionHistoryException;

@ContextConfiguration
public class AccountsServiceTest {

	@Mock
	private AccountsRepository accountsRepository;
	
	@Mock
	private TransactionRepository transactionRepository;
	
	@InjectMocks
	private AccountService accountServiceMock;
	
	AccountsDTO newAccountsDTO;
	
	
	AccountsEntity accountsEntity;
	List<AccountsEntity> accountsEntityList;
	
	
	TransactionEntity transactionEntity;
	List<TransactionEntity> transactionEntityList;
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Before
	public void initialWork() {
		MockitoAnnotations.initMocks(this);
		accountsEntityDetails();
		transactionEntityDetails();
		
	}
	
	@Test
	public void testGetAllAccounts() throws NoAccountsExceptionFound {
		when(accountsRepository.findAll()).thenReturn(accountsEntityList);
		assertFalse(accountsEntityList.isEmpty());
		newAccountsDTO=AccountsDTO.valueOf(accountsEntityList.get(0));
		assertEquals("ANZTestUser1", newAccountsDTO.getAccountName());
	}
	
	
	@Test
	public void testGetTransByAccountNumber() throws NoTransactionHistoryException {
		when(transactionRepository.findByAccountNumber(1234)).thenReturn(transactionEntityList);
		TransactionDTO transactionDTO=TransactionDTO.valueOf(transactionEntityList.get(0));
		assertEquals(transactionDTO.getAccountName(), accountServiceMock.getTransByAccountNumber(1234).get(0).getAccountName());
		
	}
	
	
	@Test(expected=NoTransactionHistoryException.class)
	public void test_throwExceptionforNonTrans() throws NoTransactionHistoryException {
		int fakeAcctNumber=2235;
		when(accountServiceMock.getTransByAccountNumber(fakeAcctNumber)).thenThrow(new NoTransactionHistoryException("No Transaction found"));
	}
	
	
	
	public void accountsEntityDetails() {
		accountsEntity=new AccountsEntity();
		accountsEntityList=new ArrayList<AccountsEntity>();
		accountsEntity.setAccountName("ANZTestUser1");
		accountsEntity.setAccountNumber(1234);
		accountsEntity.setAccountType("Savings");
		accountsEntity.setCurrency("AUD");
		accountsEntity.setBalanceDate(new Date(2020-29-1));
		accountsEntity.setOpeningAvailableBalance(5000.00);
		accountsEntityList.add(accountsEntity);
		
		
		
	}
	
	public void transactionEntityDetails() {
		transactionEntity=new TransactionEntity();
		transactionEntityList=new ArrayList<TransactionEntity>();
		transactionEntity.setAccountName("ANZTestUser1");
		transactionEntity.setAccountNumber(1234);
		transactionEntity.setCreditAmount(5000.00);
		transactionEntity.setCurrency("AUD");
		transactionEntity.setTransactionType("CREDIT");
		transactionEntity.setValueDate(new Date(2020-29-1));
		transactionEntity.setSerialNumber(1111);
		transactionEntityList.add(transactionEntity);
		
			
	}
	
}
