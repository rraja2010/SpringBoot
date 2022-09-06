package com.second.ds.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.second.ds.model.Employee;

@Repository
public class MultiDataSourceDAO {
	@Autowired
	public JdbcTemplate jdbcTemplateFirst;
	
	@Autowired
	public JdbcTemplate jdbcTemplateSecond;
	
	public List<Employee> getAllEmployeeDetails(){
		String query = "SELECT * FROM Employee";
		List<Employee> empList = new ArrayList<Employee>();
		List<Map<String, Object>> listMap=jdbcTemplateFirst.queryForList(query);
		Employee emp = null;
		for (Map<String, Object> map : listMap) {
			emp = new Employee();
			emp.setFirstName((String)map.get("FIRSTNAME"));
			emp.setLastName((String)map.get("LASTNAME"));
			emp.setAge((BigDecimal)map.get("AGE"));
			emp.setEmpId((BigDecimal)map.get("EMPLOYEEID"));
			empList.add(emp);
		}
		return empList;
	}
	
	public String secondDataSourceValidation(){
		String query = "SELECT COUNT(*) FROM DUAL";
		String output=jdbcTemplateSecond.queryForObject(query, String.class);
		String status="";
		if(output.equals(1)){
			status = "Second Data Source Connection Successfully!!";
		}else{
			status="Second Data Source Connection not Successfull!!!!";
		}
		return status;
	}
}
