package com.expensereimbursementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.expensereimbursementsystem.entities.Employee;
import com.expensereimbursementsystem.entities.UserCredentials;
import com.expensereimbursementsystem.services.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	//mapping for registration of new employee
	@PostMapping("/register")
	public UserCredentials register(@RequestParam("username") String username,
							 		@RequestParam("password") String password,
							 		@RequestBody Employee employee) {
		
		UserCredentials userCredentials = new UserCredentials(username,password);
		
		return employeeService.addEmployee(employee, userCredentials);
		
	}
	
	//implement login
	
	//view employee by id
	
	//view expense details by id
	
	//view expense details by employee id (will return a list)
	
	
}
