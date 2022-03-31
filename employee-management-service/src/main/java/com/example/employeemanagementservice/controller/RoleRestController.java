package com.example.employeemanagementservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeemanagementservice.entity.Role;
import com.example.employeemanagementservice.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleRestController {
	@Autowired
	RoleService roleService;

	@GetMapping
	public List<Role> getAllRoles() {
		return this.roleService.findAll();
	}

	@PostMapping
	public Role addRole(@RequestBody Role role) {
		return this.roleService.save(role);
	}
}
