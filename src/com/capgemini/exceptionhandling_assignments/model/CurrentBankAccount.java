package com.capgemini.exceptionhandling_assignments.model;

import com.capgemini.exceptionhandling_assignments.student_exception.DebitLimitExceedsException;
import com.capgemini.exceptionhandling_assignments.student_exception.InsufficientFundException;

public class CurrentBankAccount extends BankApp {
	private double debitLimit;
	private double borrowedAmount;
	public CurrentBankAccount() {
		super();
	
	}
	public CurrentBankAccount(long accountId, String accountHolderName, String acoountType, double accountBalance, double debitLimit) {
		super(accountId, accountHolderName, acoountType, accountBalance);
		this.debitLimit = debitLimit;
	}
	public double getDebitLimit() {
		return debitLimit;
	}
	public void setDebitLimit(double debitLimit) {
		this.debitLimit = debitLimit;
	}
	public double getBorrowedAmount() {
		return borrowedAmount;
	}
	public void setBorrowedAmount(double borrowedAmount) {
		this.borrowedAmount = borrowedAmount;
	}
	@Override
	public double withdraw(double amount) throws InsufficientFundException, DebitLimitExceedsException
	{
		double temp = getAccountBalance() - amount;
		if(temp >= 0)
			setAccountBalance(temp);
		else if(Math.abs(temp) <= (debitLimit - borrowedAmount)) {
			setAccountBalance(0);
			borrowedAmount = borrowedAmount + Math.abs(temp);
		}
		else
			throw new DebitLimitExceedsException("Debit Limit Exceeded");
		
		return getAccountBalance();
	}
	@Override
	public double deposit(double amount) throws InsufficientFundException {
		if(borrowedAmount == 0) {
			return super.deposit(amount);
		}
		else if (amount >= borrowedAmount) {
			setAccountBalance(amount - borrowedAmount);
		    borrowedAmount = 0;		
		}
	else {
		borrowedAmount = borrowedAmount - amount;
	       }
	return getAccountBalance();
	}				
	
}
