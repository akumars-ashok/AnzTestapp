package com.example.anz.repository;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.anz.main.model.AccountsEntity;
import com.example.anz.main.repository.AccountsRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@ContextConfiguration
public class AccountsRepositoryTest {
	
	@Mock
	private AccountsRepository accountsRepository;
	
	
	
	
	@Before
	public void setup() {
		
	}
	
	@Test
	public void accountstestone() {
		AccountsEntity accountsEntity=new AccountsEntity();
		Mockito.when(accountsRepository.getOne(15)).thenReturn(accountsEntity);
		assertEquals("ccccc", accountsEntity.getAccountName());
	}

}
