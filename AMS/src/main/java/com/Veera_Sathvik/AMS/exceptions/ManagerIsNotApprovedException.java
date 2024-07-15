package com.Veera_Sathvik.AMS.exceptions;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ManagerIsNotApprovedException extends RuntimeException {
	public ManagerIsNotApprovedException() {
		super("Manager is not approved");
	}
}