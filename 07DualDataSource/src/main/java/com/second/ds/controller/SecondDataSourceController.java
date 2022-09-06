package com.second.ds.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.second.ds.dao.MultiDataSourceDAO;
import com.second.ds.model.Employee;

@RestController
public class SecondDataSourceController {
	
	@Autowired
	private MultiDataSourceDAO dao;
		
	@RequestMapping("/empDetails")
	public List<Employee> getEmployeeDetailsWithfirtDataSource(){
		return dao.getAllEmployeeDetails();
	}
	
	@RequestMapping("/secondDSValidation")
	public String secondDSValidation(){
		return dao.secondDataSourceValidation();
	}
}
