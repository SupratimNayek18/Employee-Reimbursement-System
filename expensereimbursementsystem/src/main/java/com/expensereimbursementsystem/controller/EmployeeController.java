package com.expensereimbursementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.expensereimbursementsystem.entities.Employee;
import com.expensereimbursementsystem.entities.ExpenseDetails;
import com.expensereimbursementsystem.entities.UserCredentials;
import com.expensereimbursementsystem.exceptions.AccessDeniedException;
import com.expensereimbursementsystem.exceptions.EmployeeNotFoundException;
import com.expensereimbursementsystem.exceptions.ExpenseNotFoundException;
import com.expensereimbursementsystem.services.EmployeeService;
import com.expensereimbursementsystem.services.ExpenseDetailsService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	ExpenseDetailsService expenseDetailsService;

	// mapping for registration of new employee
	@PostMapping("/register")
	public UserCredentials register(@RequestParam("username") String username,
			@RequestParam("password") String password, @RequestBody Employee employee) {

		UserCredentials userCredentials = new UserCredentials(username, password);

		return employeeService.addEmployee(employee, userCredentials);

	}

	// view employee by id 
	@GetMapping("/getEmployee/{id}")
	public Employee viewEmployeeById(@PathVariable(value = "id") Integer employeeId) throws EmployeeNotFoundException {
		return employeeService.viewEmployeeById(employeeId);
	}

	// view expense details by id
	@GetMapping("/getByExpenseId/{id}")
	public ExpenseDetails fetchById(@PathVariable(value = "id") Integer expenseId) throws ExpenseNotFoundException {
		return expenseDetailsService.fetchById(expenseId);
	}

	// view expense details by employee id (will return a list)
	@GetMapping("/getByEmployeeId/{id}")
	public List<ExpenseDetails> fetchByEmployeeId(@PathVariable(value ="id") Integer employeeId) throws EmployeeNotFoundException, ExpenseNotFoundException, AccessDeniedException {
		return expenseDetailsService.fetchAll(employeeId);
	}
	
	
	
}
