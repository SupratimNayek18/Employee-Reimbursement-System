package com.expensereimbursementsystem.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<String> employeeNotFound()
	{
		
	}
	
	
}
