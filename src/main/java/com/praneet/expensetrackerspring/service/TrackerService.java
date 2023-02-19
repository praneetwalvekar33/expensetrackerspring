package com.praneet.expensetrackerspring.service;

import java.util.List;

import com.praneet.expensetrackerspring.entity.TransactionEntity;

public interface TrackerService {
	
	public List<TransactionEntity> getAllTransactionInfo();
	
	public void addTransaction(TransactionEntity theTransaction);
	
	public long getTotalCreditValue();
	
	public long getTotalExpense();
}
