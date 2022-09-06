package com.reload.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value="/check")
public class CheckController {
	
	@GetMapping(value = "/change")
	public String codeChange(){
		return "Reload the change from Check Controller without starting the server!!!";
	}
	
	@GetMapping(value = "/refresh")
	public String refresh(){
		return "Made the change as refresh mathod from the Check Controller!!it will automatic reload the change!!!!";
	}
	
}
