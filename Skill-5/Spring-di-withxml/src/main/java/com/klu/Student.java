package com.klu;

public class Student {

	private Course course;

    public void setCourse(Course course) {
        this.course = course;
    }
    private String name;
    public void setName(String name) {
    	this.name=name;
    }

    public void display() {
        System.out.println("Course: " + course.getCourseName());
        System.out.println("name: "+name);
    }
}


