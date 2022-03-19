package com.expensereimbursementsystem.services;

import java.util.List;

import com.expensereimbursementsystem.entities.Employee;
import com.expensereimbursementsystem.entities.UserCredentials;

public interface EmployeeService {

	public UserCredentials addEmployee(Employee employee,UserCredentials userCredentials);
	
	public List<Employee> viewAllEmployee();

	public void deleteEmployee(Integer employeeId);
	
	public Employee viewEmployeeById(Integer employeeId);
	
}
