package com.klu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component   // makes this class a Spring bean
public class Student {

    @Autowired   // injects Course automatically
    private Course course;
    @Value("Surya")
    private String name;
    

    public void display() {
        System.out.println("Course: " + course.getCourseName());
        System.out.println("The name is : " + name);
   
    }
}