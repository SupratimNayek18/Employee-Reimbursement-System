package com.expensereimbursementsystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.expensereimbursementsystem.entities.UserCredentials;

public interface UserCredentialsRepository extends CrudRepository<UserCredentials, Integer> {

}
