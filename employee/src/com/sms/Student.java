package com.sms;

public class Student {
	
	public int id;
	public String name;
	public int age;
	public String grade;
	
	public Student (String name , int age , String grade) { // constructor
		this.name=name;
		this.age=age;
		this.grade=grade;
	}
	
	public Student (int id , String name , int age , String grade) {
		this.id= id;
		this.name=name;
		this.age=age;
		this.grade=grade;
		
	}
}
