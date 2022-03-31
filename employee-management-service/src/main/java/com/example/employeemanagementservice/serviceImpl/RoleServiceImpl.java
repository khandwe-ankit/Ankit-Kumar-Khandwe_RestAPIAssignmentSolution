package com.example.employeemanagementservice.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employeemanagementservice.dao.RoleRepository;
import com.example.employeemanagementservice.entity.Role;
import com.example.employeemanagementservice.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;

	@Override
	public List<Role> findAll() {
		return this.roleRepository.findAll();
	}

	@Override
	public Role save(Role role) {
		return this.roleRepository.save(role);
	}

}
