package com.expensereimbursementsystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;


@Entity
@Table(name="user_credentials")
public class UserCredentials {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="user_id")
	private int Id;
	
	@Column(name="user_name")
	private  String Username;
	
	@Column(name="user_password")
	private String Password;
	
	
	public UserCredentials() {}
	
	
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
