package com.klu;

public class Student {
  private int id;
  private String name;
  private int age;

  public void setId(int id) {
    this.id = id;
  }
  public void setName(String name) {
    this.name = name;
  }
  public void setAge(int age) {
    this.age = age;
  }
  
  public void display() {
    System.out.println("The id is "+id);
    System.out.println("The name is "+ name);
    System.out.println("The age is "+age);
  }

}