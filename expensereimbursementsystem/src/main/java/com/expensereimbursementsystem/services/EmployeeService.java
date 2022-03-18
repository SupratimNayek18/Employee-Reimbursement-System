package com.expensereimbursementsystem.services;

import java.util.List;

import com.expensereimbursementsystem.entities.Employee;

public interface EmployeeService {

	public Employee addEmployee(Employee employee);
	
	public List<Employee> viewAllEmployee();

	public void deleteEmployee(Integer employeeId);
	
	public Employee viewEmployeeById(Integer employeeId);
}
