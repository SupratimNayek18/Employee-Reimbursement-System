package com.expensereimbursementsystem.services;

import java.util.List;

import com.expensereimbursementsystem.entities.ExpenseDetails;
import com.expensereimbursementsystem.exceptions.EmployeeNotFoundException;
import com.expensereimbursementsystem.exceptions.ExpenseNotFoundException;

public interface ExpenseDetailsService {
	
	public List<ExpenseDetails> fetchAll();
	
	public ExpenseDetails fetchById(Integer expenseId) throws ExpenseNotFoundException;
	
	public List<ExpenseDetails> fetchByEmployeeId(Integer employeeId) throws EmployeeNotFoundException;
	
	public ExpenseDetails updateExpense (String status, Integer id);

}
