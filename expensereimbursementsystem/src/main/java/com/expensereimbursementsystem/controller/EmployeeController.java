package com.expensereimbursementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.expensereimbursementsystem.dto.EmployeeDTO;
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
	public ResponseEntity<UserCredentials>register(@RequestParam("username") String username,
			@RequestParam("password") String password, @RequestBody EmployeeDTO employeeDto) {

		UserCredentials userCredentials = new UserCredentials(username, password);

		return new ResponseEntity<>(employeeService.addEmployee(employeeDto, userCredentials),HttpStatus.OK);

	}

	// view employee by id 
	@GetMapping("/getEmployee/{id}")
	public  ResponseEntity<EmployeeDTO> viewEmployeeById(@PathVariable(value = "id") Integer employeeId) throws EmployeeNotFoundException {
		return new ResponseEntity<>(employeeService.viewEmployeeById(employeeId),HttpStatus.OK);
	}

	// view expense details by id
	@GetMapping("/getByExpenseId/{id}")
	public ResponseEntity<ExpenseDetails> fetchById(@PathVariable(value = "id") Integer expenseId) throws ExpenseNotFoundException {
		return new ResponseEntity<>(expenseDetailsService.fetchById(expenseId),HttpStatus.OK);
	}

	// view expense details by employee id (will return a list)
	@GetMapping("/getByEmployeeId/{id}")
	public ResponseEntity<List<ExpenseDetails>> fetchByEmployeeId(@PathVariable(value ="id") Integer employeeId) throws EmployeeNotFoundException, ExpenseNotFoundException, AccessDeniedException {
		return new ResponseEntity<>(expenseDetailsService.fetchAll(employeeId),HttpStatus.OK);
	}



}
