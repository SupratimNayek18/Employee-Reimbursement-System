package com.expensereimbursementsystem.entities;

import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee_Table")
public class Request {


	public Request(Integer id, String description, String status, Locale requestDate, Locale approval, double amount) {
		super();
		this.id = id;
		this.description = description;
		this.status = status;
		this.requestDate = requestDate;
		this.approval = approval;
		Amount = amount;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RequestId")
	private Integer id;
	
	@Column(name = "Description")
	private String description;
	
	@Column(name="Status")
	private String status;
	
	@Column(name="RequestDate")
	private Locale requestDate;
	
	@Column(name="ApprovalDate;")
	private Locale approval;
	
	@Column(name="Amount")
	private double Amount;
	
	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Locale getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Locale requestDate) {
		this.requestDate = requestDate;
	}

	public Locale getApproval() {
		return approval;
	}

	public void setApproval(Locale approval) {
		this.approval = approval;
	}

	public double getAmount() {
		return Amount;
	}

	public void setAmount(double amount) {
		Amount = amount;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", description=" + description + ", status=" + status + ", requestDate="
				+ requestDate + ", approval=" + approval + ", Amount=" + Amount + "]";
	}
	

}

