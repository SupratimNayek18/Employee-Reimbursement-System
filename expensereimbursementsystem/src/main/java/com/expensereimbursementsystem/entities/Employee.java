package com.expensereimbursementsystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee_Table")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EmployeeId")
	private Integer id;
	
	@Column(name = "EmployeeName")
	private String name;
	
	@Column(name="EmployeeEmail")
	private String email;
	
	@Column(name="EmployeeRole")
	private String role;


	// Default Constructor
	
	public Employee() {}

	
	//Parameterized Constructors
	
	public Employee(String name, String email, String role) {
		this.name = name;
		this.email = email;
		this.role = role;
	}
	

	//Getters and Setters
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	//toString method
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", role=" + role + "]";
	}
	
	
}
