package com.linkedin.javacodechallenges;

public class Person {

  private String first_name = "";
  private String last_name = "";
  private int age = 0;

  public Person(String fname, String lname, int age) {
    this.first_name = fname;
    this.last_name = lname;
    this.age  = age;
  }

  public String getFirstName() {
    return this.first_name;
  }

  public String getLastName() {
    return this.last_name;
  }
  
  public String getFullName() {
    return getFirstName() + " " + getLastName();
  }

  public int getAge() {
    return this.age;
  }

  public void setFirstName(String fname) {
    this.first_name = fname;
  }

  public void setLastName(String lname) {
    this.last_name = lname;
  }
  
  public void setFullName(String fname, String lname) {
    setFirstName(fname);
    setLastName(lname);
  }

  public void getAge(int age) {
    this.age = age;
  }

  public void introduction() {
    System.out.println("Hello my name is " + this.first_name + " " + this.last_name + ". I am " + this.age + " years old.");
  }


}