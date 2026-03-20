package com.klu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {
	@Value("Surya")
	private String name;
	@Value("32511")
	private int id;
	@Value("9000725125")
	private long phone;
	@Value("99.9")
	private float marks;
	@Autowired
	Course c;
	public void display() {
		System.out.println("Name: "+name);
		System.out.println("The id is "+id);
		System.out.println("The phone number is "+phone);
		System.out.println("The marks are "+marks);
		System.out.println("The course is "+c.getCourseName());
		
		
	}
	

}
