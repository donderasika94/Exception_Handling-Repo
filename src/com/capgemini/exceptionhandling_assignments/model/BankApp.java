package com.capgemini.exceptionhandling_assignments.model;

import com.capgemini.exceptionhandling_assignments.student_exception.DebitLimitExceedsException;
import com.capgemini.exceptionhandling_assignments.student_exception.InsufficientFundException;

public class BankApp {
	private long accountId;
	private String accountHolderName;
	private String acoountType;
	private double accountBalance;
	public BankApp() {
		super();
		
	}
	public BankApp(long accountId, String accountHolderName, String acoountType, double accountBalance) {
		super();
		this.accountId = accountId;
		this.accountHolderName = accountHolderName;
		this.acoountType = acoountType;
		this.accountBalance = accountBalance;
	}
	public long getAccountId() {
		return accountId;
	}
	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public String getAcoountType() {
		return acoountType;
	}
	public void setAcoountType(String acoountType) {
		this.acoountType = acoountType;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) throws InsufficientFundException{
		this.accountBalance = accountBalance;
	}
	
	public double withdraw(double amount) throws InsufficientFundException, DebitLimitExceedsException {
		if(accountBalance >= amount)
			accountBalance = accountBalance - amount;
		else 
			throw new  InsufficientFundException("You dont have sufficient balance");
		return accountBalance;
			
	}
	public double deposit(double amount) throws InsufficientFundException {
		accountBalance = accountBalance + amount;
		return accountBalance;
	}

}
