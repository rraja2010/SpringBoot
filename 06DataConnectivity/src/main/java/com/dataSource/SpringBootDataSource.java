package com.dataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringBootDataSource {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataSource.class, args);
		System.out.println("Server has been started successfyllt!!");
		log.info("Server has been started successfyllt!!");
	}
}
