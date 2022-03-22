package com.expensereimbursementsystem;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.expensereimbursementsystem.controller.DemoController;
import com.expensereimbursementsystem.controller.EmployeeController;
import com.expensereimbursementsystem.controller.FinanceManagerController;

@SpringBootTest
class SmokeTests {
	
	@Autowired
	EmployeeController employeeController;
	
	
	
	@Autowired
	DemoController demoController;
	
	@Autowired
	FinanceManagerController financeManagerController;
	
	@Test
	void contextLoads() {
		assertThat(employeeController).isNotNull();
		assertThat(demoController).isNotNull();
		assertThat(financeManagerController).isNotNull();
	}

}
