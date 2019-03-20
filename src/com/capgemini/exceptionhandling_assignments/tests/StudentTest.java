package com.capgemini.exceptionhandling_assignments.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.exceptionhandling_assignments.model.Student;
import com.capgemini.exceptionhandling_assignments.student_exception.AgeNotWithInRangeException;
import com.capgemini.exceptionhandling_assignments.student_exception.NameNotValidException;

public class StudentTest {
	private Student student;
	@Before
	public void setUp() {
		student = new Student(111,"Ji9m Doe",24,"BE");
	}

	@Test 
	public void testClassStudentCreatedDefaultConstructor() {
		Student student = new Student();
		assertNotNull(student);
	}
	
	@Test
	public void testClassStudentcreatedParameterizedConstructor() {
		Student student = new Student(111,"Jim Doe",19,"BE");
		assertNotNull(student);
		assertEquals(111,student.getStudentRollNo());
		assertEquals("Jim Doe",student.getStudentName());
		assertEquals(19,student.getStudentAge());
		assertEquals("BE",student.getEducationCourse());
	}
	
	@Test(expected = AgeNotWithInRangeException.class)
	public void testCalculateStudentAgeRangeWithInLimit() throws AgeNotWithInRangeException  {
    student.calculateAgeOfStudent();
	}
	
	@Test(expected = NameNotValidException.class)
	public void testNameNotValid() throws NameNotValidException{
		student.checkNameOfStudent();
	}
	
}
