package com.springboot.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.springboot.execption.ExceptionResponse;
import com.springboot.execption.UserNotFoundException;
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandlerController extends ResponseEntityExceptionHandler {
	
	// this is for handling all the exception
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = 
					new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
	return	new ResponseEntity<>(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	//Below will handle the specific exception UsernotfoundExcpetion
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserException(UserNotFoundException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = 
					new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
	return	new ResponseEntity<>(exceptionResponse,HttpStatus.NOT_FOUND);
		
	}
	
}

/*
If we want to this class CustomizedResponseEntityExceptionHandlerController in other controller class also
then we have to use @ControllerAdvice 

Specialization of {@link Component @Component} for classes that declare
{@link ExceptionHandler @ExceptionHandler}, {@link InitBinder @InitBinder}, or
 {@link ModelAttribute @ModelAttribute} methods to be shared across
 multiple {@code @Controller} classes.
 
*/