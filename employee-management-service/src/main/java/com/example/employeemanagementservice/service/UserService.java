package com.example.employeemanagementservice.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.example.employeemanagementservice.entity.User;
import com.example.employeemanagementservice.exception.UserNameAlreadyExistException;

public interface UserService {

	Map<String, Object> save(User user) throws UserNameAlreadyExistException, SQLException;

	List<User> findAll();

}
