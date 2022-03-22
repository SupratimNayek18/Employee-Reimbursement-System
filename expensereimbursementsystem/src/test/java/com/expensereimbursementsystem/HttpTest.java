package com.expensereimbursementsystem;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import com.expensereimbursementsystem.dto.EmployeeDTO;
import com.expensereimbursementsystem.entities.Employee;

//@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class HttpTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
		}

	@Test
	public void testEmployeeById() {
	Employee employee = restTemplate.getForObject(getRootUrl() + "/employee/getEmployee/1", Employee.class);
	System.out.println(employee.getName());
	assertThat(employee).isNotNull();
	}
	
	@Test
	public void testAllEmployee() {
	EmployeeDTO[] employeelist = restTemplate.getForObject(getRootUrl() + "/finance_manager/fetchAllEmployees", EmployeeDTO[].class);
	System.out.println(Arrays.asList(employeelist));
	assertThat(employeelist).isNotNull();
	}

}




