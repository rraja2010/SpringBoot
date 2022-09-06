package com.dataSource.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dataSource.dao.SpringBootDAO;
import com.dataSource.model.Employee;

@RestController
public class DataSourceController {
	
	@Autowired
	private SpringBootDAO  dao;
	
	@RequestMapping("/employee")
	public List<Employee> getEmployeeInfo(){
		return dao.getEmployeeDetails();
	}
}
