package com.amit.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.amit.model.Person;

public class PersonRowMapper implements RowMapper<Person> {

	@Override
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		Person per = new Person();
		//select username as User_name,first_name as First,last_name as Last from user_details;
		per.setUsername(rs.getString("User_name"));
		per.setFirst_name(rs.getString("First"));
		per.setLast_name(rs.getString("Last"));
		return per;
	}

}
