package com.interceptor.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class FirstIntercpetor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res,
			Object handler) throws Exception {
		System.out.println("Pre Handle method is Calling from --FirstInterceptor--- class");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse res,
			Object obj, ModelAndView modelAndView) throws Exception {
		System.out.println("Post Handle method is Calling from --FirstInterceptor--- class");
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception exception)
			throws Exception {
		System.out.println("afterCompletion Handle method is Calling from --FirstInterceptor--- class");
	}
}
