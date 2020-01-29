package com.example.anz.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.anz.main.controller.AccountController;
import com.example.anz.main.model.AccountsEntity;
import com.example.anz.main.repository.AccountsRepository;
import com.example.anz.main.service.AccountService;
import com.example.anz.repository.AccountsRepositoryTest;
import com.google.gson.Gson;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers=AccountController.class)
public class AccountControllerTest {
	
	String uri = "/";
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private AccountsRepository accountsRepository;
	
	@MockBean
	private AccountService accountService;
	
	@InjectMocks
	private AccountController accountController;
	
	@Before
	public void setup() {
		System.out.println("before method..");
	}
	
	@Test
	public void testAccountsgetList() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(uri)
                .accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String actualJson = response.getContentAsString();
		
		Gson g = new Gson();
		
		AccountsEntity accountsEntity= new AccountsEntity();
		accountsEntity=g.fromJson(actualJson, AccountsEntity.class);
		System.out.println("printing name:"+accountsEntity.getAccountName());
		assertEquals("ccccc", accountsEntity.getAccountName());
	}
	
	

}
