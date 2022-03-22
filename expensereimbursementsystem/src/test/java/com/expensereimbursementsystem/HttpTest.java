package com.expensereimbursementsystem;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;
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
class HttpTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	void testEmployeeById() {
		Employee employee = restTemplate.getForObject(getRootUrl() + "/employee/getEmployee/1", Employee.class);
		assertThat(employee).isNotNull();
	}

	@Test
	void testAllEmployee() {
		
		String str = restTemplate.getForObject(getRootUrl() + "/finance_manager/fetchAllEmployees", String.class);
		JSONObject bookList = null;
		try {
			bookList = new JSONObject(str);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		assertThat(bookList).isNotNull();
	}

}




