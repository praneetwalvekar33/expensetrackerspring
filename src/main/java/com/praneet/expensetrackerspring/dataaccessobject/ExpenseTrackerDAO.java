package com.praneet.expensetrackerspring.dataaccessobject;

import java.util.List;

import com.praneet.expensetrackerspring.entity.TransactionEntity;

public interface ExpenseTrackerDAO {
	
	public List<TransactionEntity> getAllTransactionInfo();
	
	public void addTransaction(TransactionEntity theTransaction);
	
	public long getTotalCredit();

}
