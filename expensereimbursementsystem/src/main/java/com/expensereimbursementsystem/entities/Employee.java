package com.expensereimbursementsystem.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="employee_table")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employee_id")
	private Integer id;
	
	@Column(name = "employee_name")
	private String name;
	
	@Column(name="employee_email")
	private String email;
	
	@Column(name="employee_role")
	private String role;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "employee")
	private List<ExpenseDetails> expenseRequests = new ArrayList<>();
	
	// Default Constructor
	
	public Employee() {}

	
	//Parameterized Constructor

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
	
	
	public List<ExpenseDetails> getExpenseRequests() {
		return expenseRequests;
	}
	
	public void add(ExpenseDetails expenseDetails) {
		expenseRequests.add(expenseDetails);
		expenseDetails.setEmployee(this);
	}


	//toString method
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", role=" + role + "]";
	}
	
	
}
