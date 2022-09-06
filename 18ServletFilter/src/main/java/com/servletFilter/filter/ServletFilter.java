package com.servletFilter.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.stereotype.Component;
@Component
public class ServletFilter implements Filter {

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("***I am from init method of Servelt Filter***");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		System.out.println("Remote Host:" + request.getRemoteHost());
		System.out.println("Remote Address:" + request.getRemoteAddr());
		System.out.println("***I am from doFilter method of Servelt Filter***");
		filterChain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		System.out.println("***I am from destroy method of Servelt Filter***");
	}

}
