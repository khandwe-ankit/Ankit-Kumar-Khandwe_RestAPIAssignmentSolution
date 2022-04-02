package com.example.employeemanagementservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DataAlreadyExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7768217967438476231L;
	private int code;
	private String message;

	public DataAlreadyExistException(String message) {
		super();
		this.message = message;
	}

	public DataAlreadyExistException() {
		super();
	}

}
