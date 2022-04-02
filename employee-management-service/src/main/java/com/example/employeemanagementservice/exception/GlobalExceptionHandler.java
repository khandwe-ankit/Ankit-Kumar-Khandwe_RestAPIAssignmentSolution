package com.example.employeemanagementservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(EmployeeNotFoundException.class)
	public Error handleInvalidEmployeeId(EmployeeNotFoundException exception) {
		log.error("Exception while fetching employee: {}", exception.getMessage());
		return new Error(404, exception.getMessage());
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(DataAlreadyExistException.class)
	public Error handleUserNameAlreadyInUseException(DataAlreadyExistException exception) {
		log.error("Exception while saving data: {}", exception.getMessage());
		return new Error(400, exception.getMessage());
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(RoleDoesNotExistException.class)
	public Error handleRoleDoesNotExistException(RoleDoesNotExistException exception) {
		log.error("Exception while assigning role to new User: {}", exception.getMessage());
		return new Error(400, exception.getMessage());
	}
}

@Getter
@AllArgsConstructor
class Error {
	private int code;
	private String message;
}
