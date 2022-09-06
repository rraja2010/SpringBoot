package com.amit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.amit.exeption.InvalidInsuranceAmountException;
import com.amit.model.Employee;
import com.amit.model.EmployeeHealthInsurance;
import com.amit.service.EmployeeService;
import com.amit.service.OrganizationService;

@SpringBootApplication
public class SpringBootTransactionRollback {
	@Autowired
	EmployeeService employeeService;
	public static void main(String[] args) throws InvalidInsuranceAmountException{
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootTransactionRollback.class, args);
		OrganizationService organizationService = context.getBean(OrganizationService.class);

		Employee emp = new Employee();
		emp.setEmpId("emp1");
		emp.setEmpName("emp1");

		EmployeeHealthInsurance employeeHealthInsurance = new EmployeeHealthInsurance();
		employeeHealthInsurance.setEmpId("emp1");
		employeeHealthInsurance.setHealthInsuranceSchemeName("premium");
		//employeeHealthInsurance.setCoverageAmount(2000);
		employeeHealthInsurance.setCoverageAmount(0);
		organizationService.joinOrganization(emp, employeeHealthInsurance);

		
		System.out.println("SpringBootTransactionRollback started successfully!---");
	}
}