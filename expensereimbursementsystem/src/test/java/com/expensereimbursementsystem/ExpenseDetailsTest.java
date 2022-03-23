package com.expensereimbursementsystem;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import com.expensereimbursementsystem.dto.ExpenseDetailsDTO;

@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class ExpenseDetailsTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}
	
	@Test
	void testByExpenseId() {
		ExpenseDetailsDTO expenseDetailsDTO = restTemplate.getForObject(getRootUrl() + "/finance_manager/fetchbyexpenseid/1", ExpenseDetailsDTO.class);
		assertThat(expenseDetailsDTO).isNotNull();
	}
	
}
