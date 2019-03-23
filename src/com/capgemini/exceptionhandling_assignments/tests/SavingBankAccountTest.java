package com.capgemini.exceptionhandling_assignments.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.exceptionhandling_assignments.model.SavingBankAccount;
import com.capgemini.exceptionhandling_assignments.student_exception.DebitLimitExceedsException;
import com.capgemini.exceptionhandling_assignments.student_exception.InsufficientFundException;

public class SavingBankAccountTest {
	private SavingBankAccount savingBankAccount;
	@Before
	public void setUp() {
		savingBankAccount = new SavingBankAccount(123987,"Joe","SAVING",45000,false); 
	}

	@Test
	public void testSavingBankAccount() {
		SavingBankAccount account = new SavingBankAccount(123654,"Tim","SAVING",45000,true);
		assertEquals(123654,account.getAccountId());
		assertEquals("Tim",account.getAccountHolderName());
		assertEquals("SAVING",account.getAcoountType());
		assertEquals(45000,account.getAccountBalance(),0.02);
		assertTrue(account.salaryAccount);		
	}
	
	@Test(expected = InsufficientFundException.class)
	public void testSavingBankAccountWithdrawMethod() throws InsufficientFundException, DebitLimitExceedsException {
		savingBankAccount.withdraw(42000);
	}
}
