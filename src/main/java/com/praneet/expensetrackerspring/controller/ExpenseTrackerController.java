package com.praneet.expensetrackerspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praneet.expensetrackerspring.entity.TransactionEntity;
import com.praneet.expensetrackerspring.service.TrackerService;

@RestController
@RequestMapping("/eTracker")
public class ExpenseTrackerController {
	
	@Autowired
	private TrackerService trackerService;
	
	@GetMapping("/transactions")
	public List<TransactionEntity> getTransactionInfo() {
		System.out.println(">>> in getTransactionInfo method");
		
		List<TransactionEntity> transactionList = trackerService.getAllTransactionInfo();
		return transactionList;
	}
	
	
	@PostMapping("/transactions")
	public String addTransaction(@RequestBody TransactionEntity theTransactionEntity) {
		trackerService.addTransaction(theTransactionEntity);
		
		return "Transaction added successfully";
	}

	@GetMapping("/totalIncome")
	public long getTotalIncome() {
		long totalCredit = trackerService.getTotalCreditValue();
		
		return totalCredit;
	}
}