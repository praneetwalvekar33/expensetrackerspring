package com.praneet.expensetrackerspring.entity;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="transaction")
public class TransactionEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String transactionName;
	
	@Column(name="amount")
	private int transactionAmount;
	
	@Column(name="date")
	private java.time.LocalDate transactionDate;
	
	@Column(name="type")
	private int transactionType;
	
	public TransactionEntity(){
		
	}
	
	public TransactionEntity(String theTransactionName, int theTransactionAmount, String theTransactionDate,int theTransactionType) {
		this.transactionName = theTransactionName;
		this.transactionAmount = theTransactionAmount;
		this.transactionDate = LocalDate.parse(theTransactionDate);
		this.transactionType  = theTransactionType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTransactionName() {
		return transactionName;
	}

	public void setTransactionName(String transactionName) {
		this.transactionName = transactionName;
	}

	public int getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(int transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public String getTransactionDate() {
		return transactionDate.toString();
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = LocalDate.parse(transactionDate);
	}

	public int getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(int transactionType) {
		this.transactionType = transactionType;
	}

	@Override
	public String toString() {
		return "TransactionEntity [id=" + id + ", transactionName=" + transactionName + ", transactionAmount="
				+ transactionAmount + ", transactionDate=" + transactionDate + ", transactionType=" + transactionType
				+ "]";
	}
	
	
	
	
	
	

}
