package com.expensereimbursementsystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee_Table")
public class Request {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RequestId")
	private Integer id;
	
	@Column(name = "Description")
	private String description;
	
	@Column(name="Status")
	private String status;
	
	@Column(name="RequestDate")
	private String requestDate;
	
	@Column(name="private String email;")
	 private String email;
	
	@Column(name="Amount")
	private String Amount;
	
	@Column(name="EmployeeId")
	private String EmployeeId;
}

