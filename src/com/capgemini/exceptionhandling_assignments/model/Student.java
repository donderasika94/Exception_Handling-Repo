package com.capgemini.exceptionhandling_assignments.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.exceptionhandling_assignments.student_exception.AgeNotWithInRangeException;
import com.capgemini.exceptionhandling_assignments.student_exception.NameNotValidException;

public class Student {
	private int studentRollNo;
	private String studentName;
	private int studentAge;
	private String educationCourse;
	
	public Student() {
		super();
		
	}

	public Student(int studentRollNo, String studentName, int studentAge, String educationCourse) {
		super();
		this.studentRollNo = studentRollNo;
		this.studentName = studentName;
		this.studentAge = studentAge;
		this.educationCourse = educationCourse;
	}

	public int getStudentRollNo() {
		return studentRollNo;
	}

	public void setStudentRollNo(int studentRollNo) {
		this.studentRollNo = studentRollNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName)throws NameNotValidException {
		this.studentName = studentName;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge)throws AgeNotWithInRangeException {
		this.studentAge = studentAge;
	}

	public String getEducationCourse() {
		return educationCourse;
	}

	public void setEducationCourse(String educationCourse) {
		this.educationCourse = educationCourse;
	}
	
	public void calculateAgeOfStudent() throws AgeNotWithInRangeException
	{
		
			if(studentAge >= 15 && studentAge <= 21 ) 
				System.out.println("Valid Age");
			else 
				throw new AgeNotWithInRangeException("Age is not betwwen 15 to 21.");
	
    }
	
	public void checkNameOfStudent() throws NameNotValidException{
		Pattern pattern = Pattern.compile("[a-zA-Z]*");
		Matcher matcher = pattern.matcher(studentName);
		if(matcher.matches()) {
			System.out.println("Valid Input");
		}else {
			throw new NameNotValidException("Name does not contain any special character");
		}
	}
		
	
	
	
	
	

}
