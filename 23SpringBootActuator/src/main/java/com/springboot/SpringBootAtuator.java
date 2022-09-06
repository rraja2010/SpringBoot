package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootAtuator {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootAtuator.class, args);
		System.out.println("Spring Boot Actuator has been started successfully!!");
	}
}
