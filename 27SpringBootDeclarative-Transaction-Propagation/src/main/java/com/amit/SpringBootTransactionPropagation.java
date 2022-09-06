package com.amit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.amit.model.Employee;
import com.amit.model.EmployeeHealthInsurance;
import com.amit.service.EmployeeService;
import com.amit.service.OrganizationService;

@SpringBootApplication
public class SpringBootTransactionPropagation {
	@Autowired
	EmployeeService employeeService;
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootTransactionPropagation.class, args);
		OrganizationService organizationService = context.getBean(OrganizationService.class);

		Employee emp = new Employee();
		emp.setEmpId("emp1");
		emp.setEmpName("emp1");

		EmployeeHealthInsurance employeeHealthInsurance = new EmployeeHealthInsurance();
		employeeHealthInsurance.setEmpId("emp1");
		employeeHealthInsurance.setHealthInsuranceSchemeName("premium");
		employeeHealthInsurance.setCoverageAmount(20000);
		organizationService.joinOrganization(emp, employeeHealthInsurance);

		System.out.println("SpringBootTransactionPropagation started successfully!---");
	}
}