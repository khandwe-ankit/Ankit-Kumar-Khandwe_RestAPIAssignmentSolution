package com.example.employeemanagementservice.service;

import java.util.List;

import com.example.employeemanagementservice.entity.Role;

public interface RoleService {

	List<Role> findAll();

	Role save(Role role);

}
