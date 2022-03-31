package com.example.employeemanagementservice.exception;

public class RoleDoesNotExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7606100127251319951L;
	private int code;
	private String message;

	public RoleDoesNotExistException() {
		super();
	}

	public RoleDoesNotExistException(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public RoleDoesNotExistException(String message) {
		super();
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
