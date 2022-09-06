package com.springboot.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootTomcat extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringBootTomcat.class);
	}
	
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=SpringApplication.run(SpringBootTomcat.class, args);
		System.out.println("Hello World!!");
	}
}
