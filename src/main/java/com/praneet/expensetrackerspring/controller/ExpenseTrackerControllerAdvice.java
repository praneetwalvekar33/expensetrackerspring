package com.praneet.expensetrackerspring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.praneet.expensetrackerspring.errorhandling.TransactionErrorResponse;

@ControllerAdvice
public class ExpenseTrackerControllerAdvice {
	
	@ExceptionHandler
	public ResponseEntity<TransactionErrorResponse> tranctionErrorHandler(Exception theException){
		TransactionErrorResponse transactionErrorResponse = new TransactionErrorResponse();
		
		transactionErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		transactionErrorResponse.setMessage(theException.getMessage());
		transactionErrorResponse.setTimestamp(System.currentTimeMillis());
		
		
		return new ResponseEntity<>(transactionErrorResponse, HttpStatus.BAD_REQUEST);
	}

}
