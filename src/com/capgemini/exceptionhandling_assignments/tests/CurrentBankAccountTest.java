package com.capgemini.exceptionhandling_assignments.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.exceptionhandling_assignments.model.CurrentBankAccount;
import com.capgemini.exceptionhandling_assignments.student_exception.DebitLimitExceedsException;
import com.capgemini.exceptionhandling_assignments.student_exception.InsufficientFundException;

public class CurrentBankAccountTest {
	private CurrentBankAccount currentBankAccount;
	@Before
	public void setUp() {
		currentBankAccount = new CurrentBankAccount(123765,"Damon","CURRENT",40000,10000);
	}
	
	@Test
	public void testCurrentBankAccountClass() {
		CurrentBankAccount currentBankAccount = new CurrentBankAccount(123987,"Tom","CURRENT",45000,10000);
		assertEquals(123987,currentBankAccount.getAccountId());
		assertEquals("Tom",currentBankAccount.getAccountHolderName());
		assertEquals("CURRENT",currentBankAccount.getAcoountType());
		assertEquals(45000,currentBankAccount.getAccountBalance(),0.02);
		assertEquals(10000,currentBankAccount.getDebitLimit(),0.02);		
	}
	
	@Test(expected = DebitLimitExceedsException.class)
	public void testCurrentbankAccountWithdrawMethod() throws InsufficientFundException, DebitLimitExceedsException {
		currentBankAccount.withdraw(51000);
	}
	
	@Test(expected = DebitLimitExceedsException.class)
	public void testCurrentBankAccountDepositMethod() throws InsufficientFundException, DebitLimitExceedsException {
		currentBankAccount.withdraw(51000);
		currentBankAccount.deposit(10000);
	}

	

}
