package com.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="simple")
public class SpringBootController {
	@RequestMapping( value="/",method=RequestMethod.GET)
	public ResponseEntity<String> welcome(){
		return new ResponseEntity<String>("welcome to spring boot tutorial!!!",HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String sayHello(){
		return "say Hello !! how are you!!";
	}
	
	@RequestMapping(value="/sum",method=RequestMethod.GET)
	public int addition(){
		return 100+200;
	}
}

/*
My rest class is annotated with @RestController, which tells Spring Boot to consider this class as REST controller and register 
@RequestMapping paths inside it to respond to the HTTP requests.
*/