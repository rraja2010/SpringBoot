package com.threadPool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootApp {
	public static void main(String[] args) {
		SpringApplication sa = new SpringApplication(SpringBootApp.class);
		sa.run(args);
		System.out.println("Server has been started Successfully!!!!!!");
	}
}
