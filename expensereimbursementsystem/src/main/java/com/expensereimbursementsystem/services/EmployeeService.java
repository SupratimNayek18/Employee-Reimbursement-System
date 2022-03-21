package com.expensereimbursementsystem.services;

import java.util.List;

import com.expensereimbursementsystem.entities.Employee;
import com.expensereimbursementsystem.entities.UserCredentials;
import com.expensereimbursementsystem.exceptions.DeleteEmployeeException;
import com.expensereimbursementsystem.exceptions.EmployeeNotFoundException;

public interface EmployeeService {

	public UserCredentials addEmployee(Employee employee,UserCredentials userCredentials);
	
	public List<Employee> viewAllEmployee() throws EmployeeNotFoundException;

	public String deleteEmployee(Integer employeeId) throws DeleteEmployeeException;
	
	public Employee viewEmployeeById(Integer employeeId) throws EmployeeNotFoundException ;
	
}
