package com.context;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
@SpringBootApplication 
public class ContextPath {
	public static void main(String[] args) {
		SpringApplication.run(ContextPath.class, args);
		System.out.println("Application has started.");
	}
}
