package com.amit.service;
import com.amit.exeption.InvalidInsuranceAmountException;
import com.amit.model.Employee;
import com.amit.model.EmployeeHealthInsurance;

public interface OrganizationService {

	public void joinOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance)
			throws InvalidInsuranceAmountException;

	public void leaveOrganization(Employee employee, EmployeeHealthInsurance employeeHealthInsurance);
}
