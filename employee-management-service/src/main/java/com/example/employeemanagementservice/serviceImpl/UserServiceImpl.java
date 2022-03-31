package com.example.employeemanagementservice.serviceImpl;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.employeemanagementservice.dao.RoleRepository;
import com.example.employeemanagementservice.dao.UserRepository;
import com.example.employeemanagementservice.entity.Role;
import com.example.employeemanagementservice.entity.User;
import com.example.employeemanagementservice.exception.RoleDoesNotExistException;
import com.example.employeemanagementservice.exception.UserNameAlreadyExistException;
import com.example.employeemanagementservice.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public Map<String, Object> save(User user) throws SQLException {

		String userName = user.getUsername();
		if (this.userRepository.findByUsernameIgnoreCase(userName) == null) {
			/*
			 * Code to check and fetch role from DB & assigning it to user, thus avoiding
			 * making new entry to role table.
			 */
			Set<Role> roles = new HashSet<Role>();
			user.getRoles().forEach(
			        role -> {
				        String roleName = role.getName();
				        Role roleInDB = roleRepository.findByNameIgnoreCase(roleName);
				        if (roleInDB != null)
					        roles.add(roleInDB);
				        else
					        throw new RoleDoesNotExistException("Role '" + roleName
					                + "' does not exist in system, Please create the same before assigning");
			        });
			user.setRoles(roles);
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			User savedUser = this.userRepository.save(user);
			if (savedUser != null) {
				List<String> savedRoles = new ArrayList<String>();
				user.getRoles().forEach(role -> savedRoles.add(role.getName()));

				Map<String, Object> map = new LinkedHashMap<String, Object>();
				map.put("message", "User created Sucessfully");
				map.put("userId", user.getId());
				map.put("username", user.getUsername());
				map.put("role-assigned", savedRoles);

				return map;
			} else
				throw new SQLDataException("Something went wrong while saving User: " + userName);

		} else
			throw new UserNameAlreadyExistException("Username '" + userName
			        + "' is already in use, Please choose a different one!");

	}

	@Override
	public List<User> findAll() {
		return this.userRepository.findAll();
	}

}
