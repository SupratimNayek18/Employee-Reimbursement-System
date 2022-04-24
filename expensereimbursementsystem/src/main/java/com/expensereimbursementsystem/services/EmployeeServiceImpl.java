package com.expensereimbursementsystem.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expensereimbursementsystem.dto.EmployeeDTO;
import com.expensereimbursementsystem.entities.Employee;
import com.expensereimbursementsystem.entities.UserCredentials;
import com.expensereimbursementsystem.exceptions.DeleteEmployeeException;
import com.expensereimbursementsystem.exceptions.EmailAddressException;
import com.expensereimbursementsystem.exceptions.EmployeeNotFoundException;
import com.expensereimbursementsystem.exceptions.EmployeeRegistrationException;
import com.expensereimbursementsystem.repository.EmployeeRepository;
import com.expensereimbursementsystem.repository.UserCredentialsRepository;
import com.expensereimbursementsystem.utils.ConverterUtils;
import com.expensereimbursementsystem.utils.CustomPasswordEncoder;
import com.expensereimbursementsystem.utils.ValidationUtils;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	EmployeeDTO employeeDto;
	
	@Autowired
	CustomPasswordEncoder passwordEncoder;
	
	@Autowired
	UserCredentialsRepository userCredentialsRepository;

	@Override
	public Employee addEmployee(EmployeeDTO employeeDto, UserCredentials userCredentials) throws EmailAddressException, EmployeeRegistrationException {
		
		//checking is username already exists
		if(userCredentialsRepository.login(userCredentials.getUserName())!=null) {
			throw new EmployeeRegistrationException("Username already exists");
		}
		
		if(!ValidationUtils.patternMatches(employeeDto.getEmail())) throw new EmailAddressException("Invalid Email Address");
		
		//checking if email already exists
		if(employeeRepository.emailCheck(employeeDto.getEmail())!=null) {
			throw new EmployeeRegistrationException("Email already exists");
		}
		
		//encoding password
		String password = userCredentials.getUserPassword();
		userCredentials.setUserPassword(passwordEncoder.encode(password));
		
		Employee empEntity = new Employee();
		ConverterUtils.convertEmployeeDTOToEntity(employeeDto,empEntity);
		
		//saving the employee first
		UserCredentials savedCreds = userCredentialsRepository.save(userCredentials);
		
		savedCreds.setEmployee(empEntity);
		empEntity.setUserCredentials(savedCreds);
		return employeeRepository.save(empEntity);
		
	}
	

	@Override
	public Employee login(String username, String password) throws EmployeeNotFoundException {
		
		UserCredentials userCredentials = userCredentialsRepository.login(username);
		if(userCredentials==null) throw new EmployeeNotFoundException("Incorrect Credentials");
		else {
			if(passwordEncoder.matches(password, userCredentials.getUserPassword())) {
				return userCredentials.getEmployee();
			}else throw new EmployeeNotFoundException("Incorrect Credentials");
		}
		
	}

	@Override
	public List<Employee> viewAllEmployee() throws EmployeeNotFoundException {
		
		List<Employee> employeeList = (List<Employee>) employeeRepository.findAll();
		if(employeeList.isEmpty()) {
			throw new EmployeeNotFoundException("No Employees Found");
		}
		return employeeList;
		
	}

	@Override
	public String deleteEmployee(Integer employeeId) throws DeleteEmployeeException{
		
		if (employeeRepository.findById(employeeId).isPresent()) {
			employeeRepository.deleteById(employeeId);
			return "Employee Deleted Successfully";
		}else {
			throw new DeleteEmployeeException("Employee not found");
		}
		
	}

	@Override
	public EmployeeDTO viewEmployeeById(Integer employeeId) throws EmployeeNotFoundException  {
		
		Optional<Employee> employee = employeeRepository.findById(employeeId);
		if(employee.isPresent()) {
			ConverterUtils.convertEmployeeEntityToDTO(employeeDto, employee.get());
			return employeeDto;
		}
		else throw new EmployeeNotFoundException("Employee Not Found");
		
	}
	
}
