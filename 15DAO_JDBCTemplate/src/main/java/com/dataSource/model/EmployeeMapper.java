package com.dataSource.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper extends Employee implements RowMapper<Employee> {
	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println(" from MapRow RowNum :  " + rowNum);
		Employee emp = new Employee();
		emp.setFirstName((String) rs.getString("FIRSTNAME"));
		emp.setLastName((String) rs.getString("LASTNAME"));
		emp.setAge(rs.getBigDecimal("AGE"));
		emp.setEmpId(rs.getBigDecimal("EMPLOYEEID"));
		return emp;
	}
}
