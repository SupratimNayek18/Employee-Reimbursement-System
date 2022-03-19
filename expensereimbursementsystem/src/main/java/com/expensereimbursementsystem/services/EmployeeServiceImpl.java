package com.expensereimbursementsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expensereimbursementsystem.entities.Employee;
import com.expensereimbursementsystem.entities.UserCredentials;
import com.expensereimbursementsystem.repository.EmployeeRepository;
import com.expensereimbursementsystem.repository.UserCredentialsRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	UserCredentialsRepository userCredentialsRepository;

	@Override
	public UserCredentials addEmployee(Employee employee, UserCredentials userCredentials) {
		//saving the employee first
		Employee savedEmployee = employeeRepository.save(employee);
		
		//saving user creds then to get employee id
		userCredentials.setEmployee(savedEmployee);
		 
		//return saved employee from saved user creds record
		return userCredentialsRepository.save(userCredentials);
	}

	@Override
	public List<Employee> viewAllEmployee() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Employee viewEmployeeById(Integer employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

}
