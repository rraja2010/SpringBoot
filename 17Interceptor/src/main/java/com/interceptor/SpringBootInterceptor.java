package com.interceptor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootInterceptor {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootInterceptor.class, args);
		System.out.println("Server started successfully !!");
	}

}
