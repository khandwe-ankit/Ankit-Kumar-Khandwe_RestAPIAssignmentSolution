package com.example.employeemanagementservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EmployeeNotFoundException extends IllegalArgumentException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 752517581472200414L;
	private int code;
	private String message;

	public EmployeeNotFoundException(String message) {
		super();
		this.message = message;
	}

	public EmployeeNotFoundException() {
	}
}
