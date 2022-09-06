package com.amit.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amit.dao.EmployeeDao;
import com.amit.model.Employee;
import com.amit.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;

	@Override
	public void insertEmployee(Employee employee) {
		employeeDao.insertEmployee(employee);
	}
	
	@Override
	public void deleteEmployeeById(String empid) {
		employeeDao.deleteEmployeeById(empid);		
	}

}