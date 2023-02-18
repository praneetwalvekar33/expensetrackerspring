package com.praneet.expensetrackerspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praneet.expensetrackerspring.dataaccessobject.ExpenseTrackerDAO;
import com.praneet.expensetrackerspring.entity.TransactionEntity;

@Service
public class TrackerServiceImplementation implements TrackerService {
	
	private ExpenseTrackerDAO expenseTrackerDao;
	
	@Autowired
	public TrackerServiceImplementation(ExpenseTrackerDAO theExpenseTrackerDao) {
		this.expenseTrackerDao = theExpenseTrackerDao;
	}
	
	@Override
	public void addTransaction(TransactionEntity theTransaction) {
		theTransaction.setId(0);
		expenseTrackerDao.addTransaction(theTransaction);
	}

	@Override
	public long getTotalCreditValue() {
		long totalCreditValue = expenseTrackerDao.getTotalCredit();
		return totalCreditValue;
	}

	@Override
	public List<TransactionEntity> getAllTransactionInfo() {
		List<TransactionEntity> transactionList = expenseTrackerDao.getAllTransactionInfo();
		System.out.println(">>>In service implementation");
		
		return transactionList;
	}

}
