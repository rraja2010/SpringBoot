package com.springboot.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HelloWorld {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx=SpringApplication.run(HelloWorld.class, args);
		System.out.println("Hello World!!");
		
		String[] beanNames = ctx.getBeanDefinitionNames();
        System.out.println("List of beans names:");
        //Arrays.sort(beanNames);
 
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
	}
}

/*
@SpringBootApplication annotation, means this is the starting point for our Spring Boot application
*/