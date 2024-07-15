package com.Veera_Sathvik.AMS.exceptions;

import java.time.LocalDateTime;

import java.util.ArrayList;

import java.util.List;



import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.BadCredentialsException;

import org.springframework.security.core.AuthenticationException;

import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.ResponseStatus;

import org.springframework.web.context.request.WebRequest;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionsClass extends ResponseEntityExceptionHandler {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> handleConstraintViolationException(
			ConstraintViolationException ex,
			WebRequest request) {

		List<String> details = new ArrayList<String>();
		details.add(ex.getMessage());

		ApiError err = new ApiError(
				LocalDateTime.now(),
				HttpStatus.BAD_REQUEST,
				"Constraint Violations" ,
				details);

		return new ResponseEntity<>(err, err.getStatus());

	}

	@ExceptionHandler(AuthenticationException.class)
	public ResponseEntity<String> handleAuthenticationException(AuthenticationException ex) {
		if (ex instanceof BadCredentialsException) {
			//return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Manager not approved");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect username or password");
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Manager is not Approved");
		// return null;
	}

	@ExceptionHandler(ManagerIsNotApprovedException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleManagerNotApprovedException(ManagerIsNotApprovedException ex) {
		return "Manager is not approved";
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: "+ex.getMessage());
	}

	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ExceptionHandler(ForbiddenException.class)
	public ResponseEntity<?> handleForbiddenException(
			ForbiddenException ex,
			WebRequest request) {
		List<String> details = new ArrayList<String>();
		details.add(ex.getMessage());

		ApiError err = new ApiError(
				LocalDateTime.now(),
				HttpStatus.FORBIDDEN,
				"Invalid Authorization" ,
				details);

		return new ResponseEntity<>(err, err.getStatus());
	}
}




