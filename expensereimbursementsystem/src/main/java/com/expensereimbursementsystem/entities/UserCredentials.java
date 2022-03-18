package com.expensereimbursementsystem.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="user_credentials")
public class UserCredentials {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="user_name")
	private  String userName;
	
	@Column(name="user_password")
	private String userPassword;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id",referencedColumnName = "employee_id")
	private Employee employee;
	
	
	//default constructor
	
	public UserCredentials() {}
	
	
	//parameterized constructor
	
	public UserCredentials(Integer userId, String userName, String userPassword) {
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
	}


	//getters and setters
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	
	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	//toString method
	
	@Override
	public String toString() {
		return "UserCredentials [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + "]";
	}
	

	
}
