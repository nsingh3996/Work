package com.example.demo.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Transaction_Master")
public class Transactions {
	@Id
	@GeneratedValue
	@Column(name="transactionId")
	private int transactionId;
	@Column(name="amount")
	private float amount;
	@Column(name="type")
	private String type;
	

	public Transactions(float amount, String type) {
		//super();
		this.amount = amount;
		this.type = type;
	}
	public Transactions() {
		//super();
		// TODO Auto-generated constructor stub
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Transactions [transactionId=" + transactionId + ", amount=" + amount + ", type=" + type + "]";
	}
	
	
}
