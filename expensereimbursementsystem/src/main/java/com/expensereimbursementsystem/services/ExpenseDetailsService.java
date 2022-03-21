package com.expensereimbursementsystem.services;

import java.util.List;

import com.expensereimbursementsystem.entities.Employee;
import com.expensereimbursementsystem.entities.ExpenseDetails;
import com.expensereimbursementsystem.exceptions.EmployeeNotFoundException;
import com.expensereimbursementsystem.exceptions.ExpenseNotFoundException;

public interface ExpenseDetailsService {
	
	public List<ExpenseDetails> fetchAll();
	
	public ExpenseDetails fetchById(Integer id) throws ExpenseNotFoundException;
	
	public ExpenseDetails fetchByEmployeeId(Integer employeeId);
	
	public ExpenseDetails updateExpense (String status, Integer id);

}
