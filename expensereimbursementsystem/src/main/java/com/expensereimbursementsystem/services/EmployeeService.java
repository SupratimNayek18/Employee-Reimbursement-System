package com.expensereimbursementsystem.services;

import java.util.List;

import com.expensereimbursementsystem.dto.EmployeeDTO;
import com.expensereimbursementsystem.entities.Employee;
import com.expensereimbursementsystem.entities.UserCredentials;
import com.expensereimbursementsystem.exceptions.DeleteEmployeeException;
import com.expensereimbursementsystem.exceptions.EmailAddressException;
import com.expensereimbursementsystem.exceptions.EmployeeNotFoundException;
import com.expensereimbursementsystem.exceptions.EmployeeRegistrationException;

public interface EmployeeService {

	public Employee addEmployee(EmployeeDTO employeeDto,UserCredentials userCredentials) throws EmailAddressException, EmployeeRegistrationException;
	
	public Employee login(String username,String password) throws EmployeeNotFoundException;
	
	public List<Employee> viewAllEmployee() throws EmployeeNotFoundException;
	
	public String deleteEmployee(Integer employeeId) throws DeleteEmployeeException;
	
	public EmployeeDTO viewEmployeeById(Integer employeeId) throws EmployeeNotFoundException;
	
}
