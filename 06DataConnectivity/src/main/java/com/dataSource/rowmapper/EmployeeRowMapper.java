package com.dataSource.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<Employee> {
	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee emp = new Employee();
		emp.setFirstName(rs.getString("FIRSTNAME"));
		emp.setLastName(rs.getString("LASTNAME"));
		emp.setAge(rs.getBigDecimal("AGE"));
		emp.setEmpId(rs.getBigDecimal("EMPLOYEEID"));
		return emp;
	}
}
