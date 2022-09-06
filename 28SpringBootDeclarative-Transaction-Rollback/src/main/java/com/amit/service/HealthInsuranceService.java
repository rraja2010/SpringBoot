package com.amit.service;
import com.amit.exeption.InvalidInsuranceAmountException;
import com.amit.model.EmployeeHealthInsurance;

public interface HealthInsuranceService {
	void registerEmployeeHealthInsurance(EmployeeHealthInsurance employeeHealthInsurance)
			throws InvalidInsuranceAmountException;

	void deleteEmployeeHealthInsuranceById(String empid);
}