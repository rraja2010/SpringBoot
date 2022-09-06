package com.springboot.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootVersioning {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootVersioning.class, args);
		System.out.println("Spring Boot Versioning has started successfully!!!");
	}
}
