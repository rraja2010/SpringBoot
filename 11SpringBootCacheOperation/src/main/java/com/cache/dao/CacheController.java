package com.cache.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cache.model.Employee;

@RestController
public class CacheController {
	@Autowired
	private CacheDAO dao;
	
	@RequestMapping("/empDeatils")
	@Cacheable(value="empInfo")
	public List<Employee> getEmployeeDetails(){
		return dao.getEmployeeDetails();
	}
	
	@RequestMapping("/removeCahe")
    @CacheEvict(value = "empInfo", allEntries=true) 
	public List<Employee> removeEmpl(){
		return dao.getEmployeeDetails();
	}

}
