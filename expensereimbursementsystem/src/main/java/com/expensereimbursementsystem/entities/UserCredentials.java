package com.expensereimbursementsystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name="User_Credentials")
public class UserCredentials {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="User_Id")
	private int Id;
	
	@Column(name="User_name")
	private  String Username;
	
	@Column(name="User_Password")
	private String Password;
	
	
	public UserCredentials() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public UserCredentials(int id, String username, String password) {
		super();
		Id = id;
		Username = username;
		Password = password;
	}
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
		
	@Override
	public String toString() {
		return "UserCredentials [Id=" + Id + ", Username=" + Username + ", Password=" + Password + "]";
	}
	
	
}
