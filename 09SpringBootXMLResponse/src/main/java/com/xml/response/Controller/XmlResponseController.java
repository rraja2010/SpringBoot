package com.xml.response.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xml.response.dao.SpringBootDAO;
import com.xml.response.model.Employee;

@RestController
public class XmlResponseController {
	@Autowired
	private SpringBootDAO  dao;
	
	@RequestMapping("/employee")
	public List<Employee> getEmployeeInfo(){
		return dao.getEmployeeDetails();
	}
	
	@GetMapping(path="/details")
	public List<Employee> getEmployeeDetails(){
		return dao.getEmployeeDetails();
	}
}
	
