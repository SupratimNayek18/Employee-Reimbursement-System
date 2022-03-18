package com.expensereimbursementsystem.entities;

public class Employee {
	
	private Integer id;
	
	
	private String name;
	
	
	private String email;
	
	
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
