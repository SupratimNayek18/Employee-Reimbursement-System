package com.expensereimbursementsystem.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expensereimbursementsystem.entities.Employee;
import com.expensereimbursementsystem.entities.ExpenseDetails;
import com.expensereimbursementsystem.exceptions.EmployeeNotFoundException;
import com.expensereimbursementsystem.exceptions.ExpenseNotFoundException;
import com.expensereimbursementsystem.repository.EmployeeRepository;
import com.expensereimbursementsystem.repository.ExpenseDetailsRepository;

@Service
@Transactional
public class ExpenseDetailsServiceImpl implements ExpenseDetailsService {

	@Autowired
	ExpenseDetailsRepository expenseDetailsRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<ExpenseDetails> fetchAll() {
		
		return null;
	}

	@Override
	public ExpenseDetails fetchById(Integer expenseId) throws ExpenseNotFoundException {
		
		Optional<ExpenseDetails> expenseDetails = expenseDetailsRepository.findById(expenseId);
		if(expenseDetails.isPresent()) {
			return expenseDetails.get();
		}
		else throw new ExpenseNotFoundException("Expense Details Not Found");

	}

	@Override
	public List<ExpenseDetails> fetchByEmployeeId(Integer employeeId) throws EmployeeNotFoundException {
		
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		if(!employee.isPresent()) throw new EmployeeNotFoundException("Employee Not Found");
		else {
			return employee.get().getExpenseRequests();
		}
		
	}

	@Override
	public ExpenseDetails updateExpense(String status, Integer id) {
		
		return null;
	}

}
