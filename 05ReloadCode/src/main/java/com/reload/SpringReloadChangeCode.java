package com.reload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringReloadChangeCode {
	public static void main(String[] args) {
		SpringApplication.run(SpringReloadChangeCode.class, args);
		System.out.println("Server has been started Successfully!!!");
	}
}
