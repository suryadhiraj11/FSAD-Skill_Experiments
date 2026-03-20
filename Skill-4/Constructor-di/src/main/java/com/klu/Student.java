package com.klu;

public class Student {
  private int id;
  private String name;
  private double fee;
  private boolean active;
  private Integer age;
  private Double marks;

  public Student(int id, String name, double fee, boolean active, Integer age, Double marks) {
    this.id = id;
    this.name = name;
    this.fee = fee;
    this.active = active;
    this.age = age;
    this.marks = marks;
  }

  public void display() {
    System.out.println("The ID is: " + id);
    System.out.println("The name is: " + name);
    System.out.println("The fee is: " + fee);
    System.out.println("The active is: " + active);
    System.out.println("The age is: " + age);
    System.out.println("The marks is: " + marks);
  }
}
