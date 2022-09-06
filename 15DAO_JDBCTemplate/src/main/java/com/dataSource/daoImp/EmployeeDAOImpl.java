package com.dataSource.daoImp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.dataSource.dao.EmployeeDAO;
import com.dataSource.model.Employee;
import com.dataSource.model.EmployeeMapper;
import com.dataSource.query.Query;

@Repository
@Component("EmployeeDAOImpl")
public class EmployeeDAOImpl implements EmployeeDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	@Qualifier("Query")
	private Query query;

	@Override
	public List<Employee> getTotalEmployeeDetails() {
		String selectQuery = query.getSql(Query.SELECT_TOTAL_EMPLOYEE);
		List<Employee> list=jdbcTemplate.query(selectQuery, new EmployeeMapper());
		int fetchSize = jdbcTemplate.getFetchSize();
		int maxRow = jdbcTemplate.getMaxRows();
		System.out.println("FetchSize : "+fetchSize + " Max Row : "+maxRow);
		return list;
	}

	@Override
	public String getTotalEmployeeCountInInt() {
		String sqlQuery = query.getSql(Query.SELECT_TOTAL_EMPLOYEE_COUNT_INT);
		Integer totalEmployeeCount = jdbcTemplate.queryForObject(sqlQuery,
				Integer.class);
		return "Total number of employee in int type is :" + totalEmployeeCount;
	}

	@Override
	public String getTotalEmployeeCountInLong() {
		String sqlQuery = query.getSql(Query.SELECT_TOTAL_EMPLOYEE_COUNT_INT);
		Long totalEmployeeCount = jdbcTemplate.queryForObject(sqlQuery,
				Long.class);
		return "Total number of employee in Long type is :"
				+ totalEmployeeCount;
	}

	@Override
	public Employee getEmployeeDetailsWithEmpId(int empId) {
		String sqlQuery = query.getSql(Query.SELECT_EMPOYEE_DETAILS_WTIH_EMPID);
		Employee employee=jdbcTemplate.queryForObject(sqlQuery, new Object[]{empId}, new EmployeeMapper());
		return employee;
	}

	@Override
	public Integer insert(String firstName, String lastName, int age, int empId) {
		String insertQuery = query.getSql(Query.INSERT_EMPLOYEE_DETAILS);
		Integer insertCount=jdbcTemplate.update(insertQuery, new Object[] { firstName, lastName,
				age, empId });
		return insertCount;
	}

	@Override
	public Integer update(String firstName, int empId) {
		String updateQuery = query.getSql(Query.UPDATING_EMPLOYEE_DETAILS);
		Integer updateCount =jdbcTemplate.update(updateQuery, new Object[] { firstName, empId });
		return updateCount;
	}

	@Override
	public Integer deleteEmployee(int empId) {
		String deleteQuery = query.getSql(Query.DELETING_EMPLOYEE_DETAILS);
		Integer deleteCount=jdbcTemplate.update(deleteQuery, new Object[] { empId });
		return deleteCount;
	}
}
