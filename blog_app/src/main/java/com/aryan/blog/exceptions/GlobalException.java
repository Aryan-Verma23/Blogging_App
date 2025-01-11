package com.aryan.blog.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.aryan.blog.payloads.APIresponse;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<APIresponse> ResourceNotFoundExceptionHandler(ResourceNotFoundException ex){
		
		String message = ex.getMessage();
		APIresponse apiResponse = new APIresponse(message,false);
		return new ResponseEntity<APIresponse>(apiResponse,HttpStatus.NOT_FOUND);
	}

}
