package com.klu;

import org.springframework.stereotype.Component;

@Component
public class Course {

	 private String courseName = "Autowiring using Spring Framework (Annotations)";

	    public String getCourseName() {
	        return courseName;
	    }
	
}
