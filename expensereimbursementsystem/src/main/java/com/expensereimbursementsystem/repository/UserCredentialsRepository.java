package com.expensereimbursementsystem.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.expensereimbursementsystem.entities.UserCredentials;

public interface UserCredentialsRepository extends CrudRepository<UserCredentials, Integer> {
	
	@Query("select uc from UserCredentials uc where uc.userName=:userName and uc.userPassword=:userPassword")
	public UserCredentials login(String userName,String userPassword);
	
}
