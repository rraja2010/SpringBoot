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
	
	public static final String SELECT_FROM_EMPLOYEE = "select_from_employee.sql";
	// like wise any other query.
	
	public String getSql(String sqlFileName) {
		String sql = "";
		System.out.println("Config Path : "+configPath);
		File file = new File(configPath + "/" + sqlFileName);
		InputStream inputStream = null;
		try {
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
