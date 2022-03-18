package com.expensereimbursementsystem.services;

import java.util.List;

import com.expensereimbursementsystem.entities.Employee;
import com.expensereimbursementsystem.entities.ExpenseDetails;

public interface ExpenseDetailsService {
	
	public List<ExpenseDetails> fetchAll();
	
	public ExpenseDetails fetchById(Integer id);
	
	public ExpenseDetails fetchByEmployee(Employee employee);
	
	public ExpenseDetails updateExpense (String status, Integer id);
	
	

}
