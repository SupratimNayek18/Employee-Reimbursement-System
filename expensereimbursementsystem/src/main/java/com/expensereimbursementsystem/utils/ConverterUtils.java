package com.expensereimbursementsystem.utils;

import com.expensereimbursementsystem.dto.EmployeeDTO;
import com.expensereimbursementsystem.entities.Employee;

public class ConverterUtils {
	
	private ConverterUtils() {}
	
	public static void convertEmployeeDTOToEntity(EmployeeDTO employeeDto, Employee empEntity) {
		empEntity.setId(employeeDto.getId());
		empEntity.setName(employeeDto.getName());
		empEntity.setEmail(employeeDto.getEmail());
		empEntity.setRole(employeeDto.getRole());
	}
	
	public static void convertEmployeeEntityToDTO(EmployeeDTO employeeDto, Employee empEntity) {
		employeeDto.setId(empEntity.getId());
		employeeDto.setName(empEntity.getName());
		employeeDto.setEmail(empEntity.getEmail());
		employeeDto.setRole(empEntity.getRole());
	}

}
