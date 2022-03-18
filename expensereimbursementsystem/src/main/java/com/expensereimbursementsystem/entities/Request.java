package com.expensereimbursementsystem.entities;

import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee_Table")
public class Request {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RequestId")
	private Integer id;

	@Column(name = "Description")
	private String description;

	@Column(name = "Status")
	private String status;

	@Column(name = "RequestDate")
	private Locale requestDate;

	@Column(name = "ApprovalDate;")
	private Locale approvalDate;

	@Column(name = "Amount")
	private double amount;

	public Request() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Request(Integer id, String description, String status, Locale requestDate, Locale approvalDate,
			double amount) {
		super();
		this.id = id;
		this.description = description;
		this.status = status;
		this.requestDate = requestDate;
		this.approvalDate = approvalDate;
		this.amount = amount;
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

	public Locale getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(Locale approvalDate) {
		this.approvalDate = approvalDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", description=" + description + ", status=" + status + ", requestDate="
				+ requestDate + ", approvalDate=" + approvalDate + ", amount=" + amount + "]";
	}

}
