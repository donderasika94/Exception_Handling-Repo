package com.capgemini.exceptionhandling_assignments.model;

import com.capgemini.exceptionhandling_assignments.student_exception.InvalidDateException;
import com.capgemini.exceptionhandling_assignments.student_exception.InvalidMonthException;

public class Date {
	private int day;
	private int month;
	private int year;
	
	public Date() {
		super();
		
	}

	public Date(int day, int month, int year) throws InvalidDateException, InvalidMonthException {
		super();
		
		if(month == 2) {
			if(day < 29 && day > 0) 
				this.day = day;
		    else 
			   throw new InvalidDateException("not valid input");
		}else if (month == 1 || month == 5 || month == 7 || month == 8 || month ==10 || month == 12)
		{
			if(day < 31 && day > 0)
				this.day=day;
			else 
				throw new InvalidDateException("Not Valid input");
		}else if (month == 4 || month == 6 || month == 9 || month == 11)
		{
			if(day < 30 && day > 0)
				this.day=day;
			else
				throw new InvalidDateException("Not Valid input");
		}
		if(month >= 1 && month <= 12 ) 
			this.month = month;
		else
			throw new InvalidMonthException("Put valid input");
		
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month)throws InvalidMonthException {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	
	

}
