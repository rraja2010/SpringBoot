package com.dataSource.model;

import java.math.BigDecimal;

public class Employee{
	private String firstName;
	private String lastName;
	private BigDecimal age;
	private BigDecimal empId;

	public Employee() {
		System.out.println("Emloyee Constructor");
	}

	public Employee(String firstName, String lastName, BigDecimal age, BigDecimal empId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.empId = empId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public BigDecimal getAge() {
		return age;
	}

	public void setAge(BigDecimal age) {
		this.age = age;
	}

	public BigDecimal getEmpId() {
		return empId;
	}

	public void setEmpId(BigDecimal empId) {
		this.empId = empId;
	}
}
