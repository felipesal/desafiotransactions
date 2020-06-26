package com.picpay.transactions.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.picpay.transactions.services.exceptions.AuthorizationException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
		
	
	
	
	@ExceptionHandler(AuthorizationException.class)
	public ResponseEntity<StandardError> authorization(AuthorizationException e, HttpServletRequest request){
		StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.UNAUTHORIZED.value(), "Pagamento não autorizado", e.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(err);
	}
	
	
	
	
	
	
	
	
	
}
