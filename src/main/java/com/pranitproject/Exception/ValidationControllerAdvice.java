package com.pranitproject.Exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ValidationControllerAdvice extends ResponseEntityExceptionHandler{
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders h,HttpStatus s, WebRequest request){
		ErrorDetails er=new ErrorDetails();
		er.setMessage(ex.getBindingResult().toString());
		er.setDetails("Validation Failed for given Beans");
		
		return new ResponseEntity(er,HttpStatus.BAD_REQUEST);
	}

}
