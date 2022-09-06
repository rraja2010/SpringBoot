package com.dataSource.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dataSource.dao.SpringBootDAO;
import com.dataSource.rowmapper.Employee;

@RestController
public class DataSourceController {
	
	@Autowired
	private SpringBootDAO  dao;
	
	@RequestMapping(method=RequestMethod.GET,value="/allEmp")
	@ResponseBody
	public List<Employee> getEmployeeInfo(){
		return dao.getAllTheEmployeeDetails();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/allEmpUsingBean" )
	@ResponseBody
	public List<Employee> getAllEmpDetailUsingBeanPropertyRowMapper(){
		return dao.getAllEmpDetailUsingBeanPropertyRowMapper();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/totalCount")
	@ResponseBody
	public int getTotalEmpCount(){
		return dao.getTotalEmpCount();
	}
	
	@GetMapping(value="/empDetailsUsingPathVariable/{empId}")
	@ResponseBody
	public Employee getEmpById(@PathVariable String empId){
		return dao.getEmpById(new BigDecimal(empId));
	}
	//http://localhost:2085/dataSource/empDetailsUsingPathVariable/123
	
	@GetMapping(value="/empDetailsUsingRequestParam")
	@ResponseBody
	public Employee getEmpById2(@RequestParam String id){
		return dao.getEmpById(new BigDecimal(id));
	}
	//http://localhost:2085/dataSource/empDetailsUsingRequestParam?id=123
}
