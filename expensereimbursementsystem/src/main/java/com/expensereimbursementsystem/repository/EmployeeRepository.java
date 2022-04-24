package com.expensereimbursementsystem.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.expensereimbursementsystem.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	
	@Query("select emp from Employee emp where emp.email=:email")
	public Employee emailCheck(@Param("email") String email);
	
}
