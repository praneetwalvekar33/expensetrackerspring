package com.praneet.expensetrackerspring.errorhandling;

public class TransactionErrorResponse {

	private int status;
	private String message;
	private long timestamp;
	
	public TransactionErrorResponse() {
		
	}
	
	public TransactionErrorResponse(int theStatus, String theMessage, long theTimestamp) {
		this.status = theStatus;
		this.message = theMessage;
		this.timestamp = theTimestamp;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "TransactionErrorResponse [status=" + status + ", message=" + message + ", timestamp=" + timestamp + "]";
	}
	
	
	
	
}
