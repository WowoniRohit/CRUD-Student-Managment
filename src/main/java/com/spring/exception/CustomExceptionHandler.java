package com.spring.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(IdNotFound.class)
	public final ResponseEntity<Object> handleUserNotFoundException(IdNotFound accessException, WebRequest request){
		List<String> details = new ArrayList<>();
		details.add(accessException.getLocalizedMessage());
		Error error = new Error("Record Not Found...........", details);
		return new ResponseEntity<Object>(error, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> HandleAllException(Exception exception, WebRequest request){
		List<String> details = new ArrayList<>();
		details.add(exception.getLocalizedMessage());
		Error error = new Error("Opps Something Went Wrong.....", details);
		return new ResponseEntity<Object>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

}
