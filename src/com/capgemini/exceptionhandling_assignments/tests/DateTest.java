package com.capgemini.exceptionhandling_assignments.tests;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;


import org.junit.Before;
import org.junit.Test;

import com.capgemini.exceptionhandling_assignments.model.Date;
import com.capgemini.exceptionhandling_assignments.student_exception.InvalidDateException;
import com.capgemini.exceptionhandling_assignments.student_exception.InvalidMonthException;

public class DateTest {
//	private Date date;
//	@Before
//	public void setPut() {
//		date = new Date(15,15,2020);		
//	}

	@Test
	public void testCheckDateclassCretedDefaultContructor() {
		Date date = new Date();
		assertNotNull(date);
	}
	
	@Test(expected = InvalidDateException.class)
	public void testCheckDateClassCreatedParameterizedConsructor() throws InvalidDateException, InvalidMonthException {
		Date date = new Date(30,2,2020);
		assertNotNull(date);
		date.getDay();
	}
	
	@Test(expected = InvalidMonthException.class)
	public void testValidMonthException() throws InvalidDateException,InvalidMonthException{
		Date date1 = new Date(15,14,2222);
		date1.getMonth();
	}
	
/*	@Test
	public void testLeapYear() {
		Date date9 = new Date(15,2,2020);
		aseertTrue(date9.checkLeapYear());
	}*/
	
	
//	@Test
//	public void testDateObjectTwo() {
//		Date date2 = new Date(16,3,2019);
//		assertEquals(16,date2.getDay());
//		assertEquals(3,date2.getMonth());
//		assertEquals(2019,date2.getYear());		
//	}
//	
//	@Test
//	public void testDateObjectThree() {
//		Date date3 = new Date(25,6,1994);
//		assertEquals(25,date3.getDay());
//		assertEquals(6,date3.getMonth());
//		assertEquals(1994,date3.getYear());		
//	}
//	
//	@Test
//	public void testDateObjectFour() {
//		Date date4 = new Date(26,9,1994);
//		assertEquals(26,date4.getDay());
//		assertEquals(9,date4.getMonth());
//		assertEquals(1994,date4.getYear());		
//	}
//	
//	@Test
//	public void testDateObjectFive() {
//		Date date5 = new Date(25,11,1994);
//		assertEquals(25,date5.getDay());
//		assertEquals(11,date5.getMonth());
//		assertEquals(1994,date5.getYear());		
//	}
//	
//	@Test
//	public void testDateObjectSix() {
//		Date date6 = new Date(19,11,1994);
//		assertEquals(19,date6.getDay());
//		assertEquals(11,date6.getMonth());
//		assertEquals(1994,date6.getYear());		
//	}
//	
//	@Test
//	public void testDateObjectSeven() {
//		Date date7 = new Date(6,5,1995);
//		assertEquals(6,date7.getDay());
//		assertEquals(5,date7.getMonth());
//		assertEquals(1995,date7.getYear());		
//	}
//	
//	@Test(expected = InvalidMonthException.class)
//	public void testInvalidMonthException()throws InvalidMonthException{
//		date.invalidMonth();
//	}
//	
//	@Test(expected = InvalidDateException.class)
//	public void testInvalidDateException()throws InvalidDateException{
//		Date date9 = new Date(29,2,2020);
//		date9.isValidDate();
//	}
	
	

}
