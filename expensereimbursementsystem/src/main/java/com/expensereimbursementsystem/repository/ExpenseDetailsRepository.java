package com.expensereimbursementsystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.expensereimbursementsystem.entities.ExpenseDetails;

public interface ExpenseDetailsRepository extends CrudRepository<ExpenseDetails, Integer> {

}
