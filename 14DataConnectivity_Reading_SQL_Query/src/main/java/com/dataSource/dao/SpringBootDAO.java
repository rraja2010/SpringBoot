package com.dataSource.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dataSource.model.Employee;
import com.dataSource.query.Query;
 

@Repository
public class SpringBootDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	@Qualifier("Query")
	private Query query;
	
	public List<Employee> getEmployeeDetails(){
		List<Employee> list = new ArrayList<Employee>();
		String selectQuery = query.getSql(Query.SELECT_FROM_EMPLOYEE);
		System.out.println("selectQuery : "+selectQuery);
		List<Map<String,Object>> mapList=jdbcTemplate.queryForList(selectQuery);
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
