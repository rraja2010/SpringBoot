package com.context.restController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Mapping {

	@RequestMapping("/context")
	public  String changeContextPath(){
		return "Application context file got changed!!!";
	}
}
