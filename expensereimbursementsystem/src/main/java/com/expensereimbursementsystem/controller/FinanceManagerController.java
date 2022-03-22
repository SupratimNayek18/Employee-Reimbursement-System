package com.expensereimbursementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.expensereimbursementsystem.entities.Employee;
import com.expensereimbursementsystem.entities.ExpenseDetails;
import com.expensereimbursementsystem.exceptions.AccessDeniedException;
import com.expensereimbursementsystem.exceptions.EmployeeNotFoundException;
import com.expensereimbursementsystem.exceptions.ExpenseNotFoundException;
import com.expensereimbursementsystem.services.EmployeeService;
import com.expensereimbursementsystem.services.ExpenseDetailsService;

@RestController
@RequestMapping("finance_manager")
public class FinanceManagerController {
	
	@Autowired
	ExpenseDetailsService expensedetailsService;
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/fetchallemployees")
	public ResponseEntity<List<Employee>> fetchAllEmployees() throws EmployeeNotFoundException
	{
		return new ResponseEntity<>(employeeService.viewAllEmployee(),HttpStatus.OK);
	}
	
	@GetMapping("/fetchbyexpenseid/{id}")
	public ResponseEntity<ExpenseDetails> fetchByExpenseId(@PathVariable (value="id") Integer id) throws ExpenseNotFoundException
	{
		return new ResponseEntity<>(expensedetailsService.fetchById(id),HttpStatus.OK);
	}
	
	@GetMapping("/fetchbyemployeeid/{id}")
	public ResponseEntity<List<ExpenseDetails>> fetchByEmployeeId(@PathVariable (value="id") Integer id) throws EmployeeNotFoundException
	{
		return new ResponseEntity<>(expensedetailsService.fetchByEmployeeId(id),HttpStatus.OK);
	}
	
	@GetMapping("/fetchallrequests/{id}")
	public ResponseEntity<List<ExpenseDetails>> fetchAllRequests(@PathVariable (value="id") Integer id) throws ExpenseNotFoundException, EmployeeNotFoundException, AccessDeniedException
	{
		return new ResponseEntity<>(expensedetailsService.fetchAll(id),HttpStatus.OK);
	}
	
	@PutMapping("/updatestatusofrequest")
	public ResponseEntity<String>updateRequestStatus(@RequestParam Integer employeeId ,@RequestParam String status ,@RequestParam Integer id) throws EmployeeNotFoundException, AccessDeniedException
	{
		return new ResponseEntity<>(expensedetailsService.updateExpense(employeeId, status, id),HttpStatus.OK);
	}
	
}


