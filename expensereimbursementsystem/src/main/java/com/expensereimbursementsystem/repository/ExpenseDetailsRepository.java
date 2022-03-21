package com.expensereimbursementsystem.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.expensereimbursementsystem.entities.ExpenseDetails;

public interface ExpenseDetailsRepository extends CrudRepository<ExpenseDetails, Integer> {

	@Modifying
	@Query("update expense_details ed set ed.status=:status where ed.id=:id")
	public Integer updateStatus(@Param("status") String status,
								@Param("id") Integer id); 
	
}
