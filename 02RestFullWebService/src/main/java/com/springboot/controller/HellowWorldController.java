package com.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.HelloWorld;

@RestController
public class HellowWorldController {
 
 	@RequestMapping(path = "/hello-world", method = RequestMethod.GET)
 	public String helloWorld(  ) {      
 		return "Hello world!!" ; 
 	} 
 	
 	//we can use GetMapping if the request type is GET
 	@GetMapping(path = "/hello-get")
 	public String helloWorldGet(  ) {      
 		return "Hello world Get!!" ; 
 	} 
 	
 	//it will return the HelloWorld bean object
 	@GetMapping(path = "/hello-world-bean")
 	public HelloWorld getHelloWorldBean() {
 		return new HelloWorld("Hello-world-bean");
 	}
 	
 	//http://localhost:2019/hello-bean/path-variable/kumar
 	@GetMapping(path = "/hello-bean/path-variable/{name}")
 	public HelloWorld getHelloWorldPathVariable(@PathVariable String name) {
 		return new HelloWorld(String.format("Hello world, %s",name));
 		//%s is getting replaced with name
 	}
 	
} 