package com.dataSource.query;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.flink.hadoop.shaded.com.google.common.io.Closeables;
import org.apache.flink.shaded.com.google.common.io.CharStreams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component(value="Query")
public class Query {
	
	@Value("${config.path}")
	public String configPath;
	
	public static final String SELECT_TOTAL_EMPLOYEE_COUNT_INT = "select_total_employee_count_int.sql";
	public static final String SELECT_TOTAL_EMPLOYEE_COUNT_LONG = "select_total_employee_count_long.sql";
	public static final String SELECT_EMPOYEE_DETAILS_WTIH_EMPID = "select_employee_details_with_empId.sql";
	
	public static final String SELECT_TOTAL_EMPLOYEE = "select_total_employee.sql";
	
	public static final String INSERT_EMPLOYEE_DETAILS= "insert_employee_details.sql";
	public static final String UPDATING_EMPLOYEE_DETAILS= "update_employee_details.sql";
	public static final String DELETING_EMPLOYEE_DETAILS= "delete_employee_details.sql";
	
	// like wise any other query.
	
	public String getSql(String sqlFileName) {
		String sql = "";
		File file = new File(configPath + "/" + sqlFileName);
		InputStream inputStream = null;
		try {
			System.out.println("** SQL FILE NAME :>>>>>>-"+file.getAbsolutePath());
			inputStream = new FileInputStream(file);
			sql = CharStreams.toString(new InputStreamReader(inputStream));

			if (null == sql || sql.isEmpty()) {
				Closeables.closeQuietly(inputStream);
				throw new IOException(
						"File path to SQL file could not be read!!!!!");
			}
		} catch (IOException e) {
			e.printStackTrace();
			return sql;
		} finally {
			Closeables.closeQuietly(inputStream);
		}
		return sql;
	}
}
