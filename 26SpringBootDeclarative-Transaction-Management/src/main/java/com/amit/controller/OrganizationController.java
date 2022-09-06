package com.amit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.amit.model.Employee;
import com.amit.model.EmployeeHealthInsurance;
import com.amit.service.OrganizationService;

@RestController
@RequestMapping("/org")
public class OrganizationController {

	//http://localhost:2022/org/join/ 
	// Better Run on postman
	@Autowired
	OrganizationService organizationService;
	
	
	//@RequestMapping( value="/join/",method={RequestMethod.POST})
	@PostMapping( value="/join/")
	public String joinOrganization() {
		Employee emp = new Employee();
		emp.setEmpId("one");
		emp.setEmpName("Amit");

		EmployeeHealthInsurance employeeHealthInsurance = new EmployeeHealthInsurance();
		employeeHealthInsurance.setEmpId("one");
		employeeHealthInsurance.setHealthInsuranceSchemeName("premium");
		employeeHealthInsurance.setCoverageAmount(20000);

		organizationService.joinOrganization(emp, employeeHealthInsurance);
		return "Registration has done successfully!!";
	}

	
	@RequestMapping(value = "/welcome/", method = RequestMethod.GET)
	public String welcomepage() {
		return "Welcome to Transactional management \n";
	}

	//@RequestMapping( value="/leave/",method={RequestMethod.DELETE})
	//http://localhost:2022/org/leave/ 
	@DeleteMapping( value="/leave/")
	public String leaveOrganization() {
		Employee emp = new Employee();
		emp.setEmpId("one");

		EmployeeHealthInsurance employeeHealthInsurance = new EmployeeHealthInsurance();
		employeeHealthInsurance.setEmpId("one");
		organizationService.leaveOrganization(emp, employeeHealthInsurance);
		return "Deletion has done successfully!!";
	}
}
