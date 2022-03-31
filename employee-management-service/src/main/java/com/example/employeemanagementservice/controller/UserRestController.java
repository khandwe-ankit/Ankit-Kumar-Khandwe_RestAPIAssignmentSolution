package com.example.employeemanagementservice.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeemanagementservice.entity.User;
import com.example.employeemanagementservice.exception.UserNameAlreadyExistException;
import com.example.employeemanagementservice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	UserService userService;

	@GetMapping
	public List<User> getAllUsers() {
		return this.userService.findAll();
	}

	@PostMapping
	public Map<String, Object> addUser(@RequestBody User user) throws UserNameAlreadyExistException, SQLException {
		return this.userService.save(user);
	}

}
