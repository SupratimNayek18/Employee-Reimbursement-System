package com.expensereimbursementsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.expensereimbursementsystem.entities.Employee;
import com.expensereimbursementsystem.entities.ExpenseDetails;
import com.expensereimbursementsystem.exceptions.EmployeeNotFoundException;
import com.expensereimbursementsystem.exceptions.ExpenseNotFoundException;
import com.expensereimbursementsystem.repository.ExpenseDetailsRepository;

public class ExpenseDetailsServiceImpl implements ExpenseDetailsService {

	@Autowired
	ExpenseDetailsRepository expenseDetailsRepository;

	@Override
	public List<ExpenseDetails> fetchAll() {
		
		return null;
	}

	@Override
	public ExpenseDetails fetchById(Integer id) throws ExpenseNotFoundException {
		
		Optional<ExpenseDetails> expenseDetails = expenseDetailsRepository.findById(id);
		if(expenseDetails.isPresent())
		{
			return expenseDetails.get();
		}
		else
		{
			throw new ExpenseNotFoundException("Expense Details Not Found");
		}
		
	}

	@Override
	public ExpenseDetails fetchByEmployeeId(Integer employeeId) {
		
		return null;
	}

	@Override
	public ExpenseDetails updateExpense(String status, Integer id) {
		
		return null;
	}

}
