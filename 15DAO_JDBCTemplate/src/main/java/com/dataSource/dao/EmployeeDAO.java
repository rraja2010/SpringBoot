package com.dataSource.dao;

import java.util.List;

import com.dataSource.model.Employee;

public interface EmployeeDAO {
	
	public abstract List<Employee> getTotalEmployeeDetails();
	public abstract String getTotalEmployeeCountInInt();
	public abstract String getTotalEmployeeCountInLong();
	public abstract Employee getEmployeeDetailsWithEmpId(int empId);
	
	
	public abstract Integer insert(String firstName,String lastName, int age, int empId);
	public abstract Integer update(String firstName, int empId);
	public abstract Integer deleteEmployee(int empId);
	
	
}
