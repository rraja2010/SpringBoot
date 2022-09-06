package com.dataSource.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dataSource.rowmapper.Employee;
import com.dataSource.rowmapper.EmployeeRowMapper;
 

@Repository
public class SpringBootDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static String QUERY = "select * from Employee";
	private static String QUERY_BY_EMP_ID = "select * from employee where employeeid=?";
	private static String QUERY_FOR_TOTAL_COUNT = "select count(*) from Employee";
	
	public List<Employee> getAllTheEmployeeDetails(){
		List<Employee> list = new ArrayList<Employee>();
		List<Map<String,Object>> mapList=jdbcTemplate.queryForList(QUERY);
		for (Map<String, Object> map : mapList) {
			Employee emp = new Employee();
			emp.setFirstName((String)map.get("FIRSTNAME"));
			emp.setLastName((String)map.get("LASTNAME"));
			emp.setAge((BigDecimal)map.get("AGE"));
			emp.setEmpId((BigDecimal)map.get("EMPLOYEEID"));
			list.add(emp);
		}
		return list;
	}
	
	public List<Employee> getAllEmpDetailUsingBeanPropertyRowMapper(){
		List<Employee> empList  = jdbcTemplate.query(QUERY,
				new BeanPropertyRowMapper(Employee.class));
		return empList;
	}
	
	public Employee getEmpById(BigDecimal empId) {
		Employee emp = jdbcTemplate.queryForObject(QUERY_BY_EMP_ID, new Object[] { empId }, new EmployeeRowMapper());
		return emp;
	}

	public int getTotalEmpCount() {
		int totalCount = jdbcTemplate.queryForObject(QUERY_FOR_TOTAL_COUNT, Integer.class);
		return totalCount;
	}
	
	/*
	Table creation query
	SHOW DATABASES;
	create database amitdb;
	use amitdb;
	show tables;
	CREATE TABLE Employee (
			FIRSTNAME VARCHAR(30) NOT NULL,
			LASTNAME VARCHAR(30) NOT NULL,
			AGE int(2),
			EMPLOYEEID int(6)
			);
            
            
	desc Employee;
	insert into Employee values("amit","kumar",31,1030);
	insert into Employee values("Niraj","kumar",27,1025);

	alter table Employee modify EMPLOYEEID NUMERIC;
	
	*/
	
}	
