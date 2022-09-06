package com.amit.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class EmployeeHealthInsurance {

	private String empId;
	private String healthInsuranceSchemeName;
	private int coverageAmount;
}
