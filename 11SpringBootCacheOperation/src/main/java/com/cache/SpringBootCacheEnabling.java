package com.cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringBootCacheEnabling {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootCacheEnabling.class, args);
		System.out.println("Server has started successfully!!!!!");
	}
}
