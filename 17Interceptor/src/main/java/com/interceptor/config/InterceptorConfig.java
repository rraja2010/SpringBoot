package com.interceptor.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.interceptor.service.FirstIntercpetor;
import com.interceptor.service.SecondInterceptor;
import com.interceptor.service.ThirdInterceptor;

@Component
public class InterceptorConfig extends WebMvcConfigurerAdapter   {
	@Autowired
	public FirstIntercpetor firstIntercpetor;
	
	@Autowired
	public SecondInterceptor secondIntercepto;
	
	@Autowired
	public ThirdInterceptor ThirdInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(firstIntercpetor);
		registry.addInterceptor(secondIntercepto);
		registry.addInterceptor(ThirdInterceptor);
		
	}
}
/*
We will have to register this Interceptor with InterceptorRegistry by using WebMvcConfigurerAdapter
as shown in the above
*/