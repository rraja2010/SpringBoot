package com.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.versioning.bean.Name;
import com.springboot.versioning.bean.StudentV1;
import com.springboot.versioning.bean.StudentV2;

@RestController
public class StudentVersioningController {

	
	//URI Versioning start
	@GetMapping("v1/student")
	public StudentV1 studentv1() {
		return new StudentV1("Amit Kumar");
	}

	@GetMapping("v2/student")
	public StudentV2 studentv2() {
		return new StudentV2(new Name("Amit", "Kumar"));
	}
	//URI Versioning end
	
	
	
	
	//Request Parameter versioning start
	@GetMapping(value = "/student/param", params = "version=1")
	public StudentV1 paramV1() {
		return new StudentV1("Amit Kumar");
	}

	@GetMapping(value = "/student/param", params = "version=2")
	public StudentV2 paramV2() {
		return new StudentV2(new Name("Amit", "Kumar"));
	}
	
	//Request Parameter versioning end

	
	//(Custom) Headers versioning start
	@GetMapping(value = "/student/header", headers = "X-API-VERSION=1")
	public StudentV1 headerV1() {
		return new StudentV1("Amit Kumar");
	}

	@GetMapping(value = "/student/header", headers = "X-API-VERSION=2")
	public StudentV2 headerV2() {
		return new StudentV2(new Name("Amit", "Kumar"));
	}
	
	//(Custom) Headers versioning end
	
	
	//Media type versioning (a.k.a “content negotiation” or “accept header”) start

	@GetMapping(value = "/student/produces", produces = "application/vnd.company.app-v1+json")
	public StudentV1 producesV1() {
		return new StudentV1("Amit Kumar");
	}

	@GetMapping(value = "/student/produces", produces = "application/vnd.company.app-v2+json")
	public StudentV2 producesV2() {
		return new StudentV2(new Name("Amit", "Kumar"));
	}
	
	//Media type versioning (a.k.a “content negotiation” or “accept header”) end
}
