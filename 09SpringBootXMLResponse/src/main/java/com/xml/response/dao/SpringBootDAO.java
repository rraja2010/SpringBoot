package com.xml.response.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.xml.response.model.Employee;
 

@Repository
public class SpringBootDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static String QUERY = "select * from Employee";
	
	
	public List<Employee> getEmployeeDetails(){
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
}	
