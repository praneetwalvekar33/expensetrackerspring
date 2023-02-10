package com.praneet.expensetrackerspring.dataaccessobject;

import java.util.List;

import com.praneet.expensetrackerspring.entity.TransactionEntity;

public interface ExpenseTrackerDAO {
	
	public List<TransactionEntity> getAllTransactionInfo();

}
