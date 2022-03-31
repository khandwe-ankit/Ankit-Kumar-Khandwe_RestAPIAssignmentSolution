package com.example.employeemanagementservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserNameAlreadyExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7768217967438476231L;
	private int code;
	private String message;

	public UserNameAlreadyExistException(String message) {
		super();
		this.message = message;
	}

	public UserNameAlreadyExistException() {
		super();
	}

}
