package com.second.ds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootMultiDataSource {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMultiDataSource.class, args);
		System.out.println("Server has been started successfully !!!!");
	}
}
