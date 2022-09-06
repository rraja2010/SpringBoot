package com.dataSource.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dataSource.daoImp.EmployeeDAOImpl;
import com.dataSource.model.Employee;

@RestController
public class DataSourceController {
	
	@Autowired
	@Qualifier("EmployeeDAOImpl")
	private EmployeeDAOImpl  dao;
	
	@RequestMapping("/employee")
	public List<Employee> getEmployeeInfo(){
		return dao.getTotalEmployeeDetails();
	}
	
	@RequestMapping("/int")
	public String getTotalEmployeeCount(){
		return dao.getTotalEmployeeCountInInt();
	}
	
	@RequestMapping("/long")
	public String getTotalEmployeeCountInLong(){
		return dao.getTotalEmployeeCountInLong();
	}
	
	@RequestMapping("/empId")
	public Employee getSingleEmpDetails(){
		int empId = 46978;
		return dao.getEmployeeDetailsWithEmpId(empId);
	}
	
	@RequestMapping("/insert")
	public String insertEmployee(){
		String fristNmame ="Amit";
		String lastName = "Kumar";
		int age = 29;
		int empId = 46978;
		int count = dao.insert(fristNmame, lastName, age, empId);
		return count + " recodes has inserted successfully!!";
	}
	
	@RequestMapping("/update")
	public String updateEmployee(){
		int empId = 46978;
		String fristNmame ="Amit";
		int count = dao.update(fristNmame, empId);
		return count + " records has updated";
	}
	
	@RequestMapping("/delete")
	public String deleteEmployee(){
		int empId = 46978;
		int count = dao.deleteEmployee(empId);
		return count + " records has deleted";
	}
}
