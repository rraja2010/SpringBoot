package com.amit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.amit.exeption.InvalidInsuranceAmountException;
import com.amit.model.Employee;
import com.amit.model.EmployeeHealthInsurance;
import com.amit.service.EmployeeService;
import com.amit.service.HealthInsuranceService;
import com.amit.service.OrganizationService;

@Service
//@Transactional
public class OrganzationServiceImpl implements OrganizationService {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	HealthInsuranceService healthInsuranceService;

	@Override
	@Transactional(rollbackFor = InvalidInsuranceAmountException.class)
	//@Transactional(propagation = Propagation.REQUIRED)
	public void joinOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance)
			throws InvalidInsuranceAmountException {
		employeeService.insertEmployee(employee);
		System.out.println("Employee Details has inserted successfully.");
		//Unchecked Exception
		/*
		if (employee.getEmpId().equals("emp1")) {
			System.out.println("I am about to throw runtime exception.");
			throw new RuntimeException("thowing runtime exception to test transaction rollback");
		}
		*/
		
		try {
			healthInsuranceService.registerEmployeeHealthInsurance(employeeHealthInsurance);
		} catch (InvalidInsuranceAmountException e) {
			throw new InvalidInsuranceAmountException("Exception is thrown");
		}
		
	}

	@Override
	public void leaveOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance) {
		employeeService.deleteEmployeeById(employee.getEmpId());
		healthInsuranceService.deleteEmployeeHealthInsuranceById(employeeHealthInsurance.getEmpId());
	}
}


/*

Case 1: Without using any transaction comments line 26,27
	It will insert the employee details in the employee table and then it is throwing
		Runtime exception so Employee health Insurance details will not be saved in the db.

Case 2: Transaction with unchecked exception - Un comments line 27
		2022-03-08 18:29:23.483  INFO 33636 --- [  restartedMain] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
Employee details has been inserted successfull!!
Exception in thread "restartedMain" java.lang.reflect.InvocationTargetException

	Even though Employee details has inserted into the DB - due to runtime exception those inserted data has roll backed.


Case 3: Transaction with checked Exception.
		if coverage amount is greater then zero then InvalidInsuranceAmoutException will not thrown.
		Case 1: check SpringBootTransactionRollback line number
				employeeHealthInsurance.setCoverageAmount(2000); - should be uncommented.
			if coverage amount is more then 0 then there is no exception, data will be inserted successfully.
		
		Case 2: 
			Coverage amount is equal to zero
				then InvalidInsuranceAmoutException thrown but employee details has been inserted into the DB.
				check SpringBootTransactionRollback line number
				it should be like below.
				//employeeHealthInsurance.setCoverageAmount(2000);
				employeeHealthInsurance.setCoverageAmount(0);
				
				it has throw
				Caused by: com.amit.exeption.InvalidInsuranceAmountException: Exception is thrown
				and data has inserted successfully in the employee table
				So no proper roll back happen.
				For smooth execution need to add roll back property to the Transaction annotation.
				@Transactional(rollbackFor = InvalidInsuranceAmountException.class)
*/