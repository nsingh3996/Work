package com.example.demo.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Customer_master")
public class Customer {
	@Id
	@GeneratedValue	
	@Column(name="id")
	private Long userId;
	
	@Column(name="accountNumber")
	private String accountNumber;
	
	@Column(name="customerName")
	private String customerName;
	
	@Column(name="panNumber")
	private String panNumber;
	
	@Column(name="aadharNumber")
	private String aadharNumber;
	
	@Column(name="phoneNo")
	private String phoneNo;
	
	@Column(name="amount")
	private float amount;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name="userId")
	Set<Transactions> transaction = new HashSet<>();

	public Customer(String accountNumber, String customerName, String panNumber, String aadharNumber, String phoneNo,
			float amount, String username, String password) {
		//super();
		this.accountNumber = accountNumber;
		this.customerName = customerName;
		this.panNumber = panNumber;
		this.aadharNumber = aadharNumber;
		this.phoneNo = phoneNo;
		this.amount = amount;
		this.username = username;
		this.password = password;
	}

	public Customer() {
		//super();
		// TODO Auto-generated constructor stub
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public String getAadharNumber() {
		return aadharNumber;
	}
	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Transactions> getTransaction() {
		return transaction;
	}
	public void setTransaction(Set<Transactions> transaction) {
		this.transaction = transaction;
	}
	
	
	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", accountNumber=" + accountNumber + ", customerName=" + customerName
				+ ", panNumber=" + panNumber + ", aadharNumber=" + aadharNumber + ", phoneNo=" + phoneNo + ", amount="
				+ amount + ", username=" + username + ", password=" + password + ", transaction=" + transaction + "]";
	}
	
	
	
	
	
}
