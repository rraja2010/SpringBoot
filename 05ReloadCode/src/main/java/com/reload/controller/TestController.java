package com.reload.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/testC")
public class TestController {
	
	@RequestMapping(value = "/change",method =RequestMethod.GET)
	public String codeChange(){
		return "From TestController class - Reload the change without starting the server!!!";
	}
	
	@GetMapping("/refresh")
	public String refresh(){
		return "From TestController class - Made the change as refresh mathod!!it will automatic reload the change!!!!";
	}

}
