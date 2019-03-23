package com.capgemini.exceptionhandling_assignments.model;

import com.capgemini.exceptionhandling_assignments.student_exception.DebitLimitExceedsException;
import com.capgemini.exceptionhandling_assignments.student_exception.InsufficientFundException;

public class SavingBankAccount extends BankApp {
	public boolean salaryAccount;
	public static final double MINIMUM_BALANCE = 10000;
	public SavingBankAccount() {
		super();
		
	}
	public SavingBankAccount(long accountId, String accountHolderName, String acoountType, double accountBalance, boolean salaryAccount) {
		super(accountId, accountHolderName, acoountType, accountBalance);
		this.salaryAccount = salaryAccount;
	}
	public boolean isSalaryAccount() {
		return salaryAccount;
	}
	public void setSalaryAccount(boolean salaryAccount) {
		this.salaryAccount = salaryAccount;
	}
	@Override
	public double withdraw(double amount) throws InsufficientFundException, DebitLimitExceedsException {
		if(salaryAccount)
			return super.withdraw(amount);
		else
		{
					if(getAccountBalance() - amount >= MINIMUM_BALANCE)
						setAccountBalance(getAccountBalance() - amount); 
					else
						throw new InsufficientFundException("You dont have sufficient balance");
					return getAccountBalance();		
		}
	}
	
	


}
