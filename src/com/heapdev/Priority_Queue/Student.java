package com.heapdev.Priority_Queue;

public class Student implements Comparable<Student> {

	private String name;
	private int age;
	private int rollNumber;

	public Student(String name, int age, int rollNumber) {
		this.name = name;
		this.rollNumber = rollNumber;
		this.age = age;
	}

	@Override
	public int compareTo(Student otherStudent) {
		return -otherStudent.getName().compareTo(this.getName());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}

	@Override
	public String toString() {
		return this.getName();
	}

}
