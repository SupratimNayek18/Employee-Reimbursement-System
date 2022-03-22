package com.expensereimbursementsystem.utils;

import com.expensereimbursementsystem.dto.EmployeeDTO;
import com.expensereimbursementsystem.entities.Employee;

public class ConverterUtils {
	
	private ConverterUtils() {}
	
	public static void convertEmployeeDTOToEntity(EmployeeDTO employeeDto, Employee empEntity) {
		empEntity.setName(employeeDto.getName());
		empEntity.setEmail(employeeDto.getEmail());
		empEntity.setRole(employeeDto.getRole());
	}
	
	public static void convertEmployeeEntityToDTO(EmployeeDTO employeeDto, Employee empEntity) {
		employeeDto.setEmail(empEntity.getEmail());
		employeeDto.setId(empEntity.getId());
	}

}