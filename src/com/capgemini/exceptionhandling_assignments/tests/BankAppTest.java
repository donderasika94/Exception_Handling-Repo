package com.capgemini.exceptionhandling_assignments.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import com.capgemini.exceptionhandling_assignments.model.BankApp;
import com.capgemini.exceptionhandling_assignments.student_exception.DebitLimitExceedsException;
import com.capgemini.exceptionhandling_assignments.student_exception.InsufficientFundException;

public class BankAppTest {
	private BankApp bankapp;
	@Before
	public void setUp() {
		bankapp = new BankApp(156789,"Tim","SAVING",50000);
	}

	@Test
	public void testBankAppConstructor() {
		BankApp bankapp = new BankApp(123765,"Jim Doe","SAVING",45000);
		assertEquals(123765,bankapp.getAccountId());
		assertEquals("Jim Doe",bankapp.getAccountHolderName());
		assertEquals("SAVING",bankapp.getAcoountType());
		assertEquals(45000,bankapp.getAccountBalance(),0.02);
	}
	@Test(expected = InsufficientFundException.class)
	public void testBankAppWithdrawMethod() throws InsufficientFundException, DebitLimitExceedsException {
		bankapp.withdraw(51000.0);
	}
	
	@Test 
	public void testBankAppDepositMethod() throws InsufficientFundException{
		assertEquals(51000,bankapp.deposit(1000),0.02);
	}
}
