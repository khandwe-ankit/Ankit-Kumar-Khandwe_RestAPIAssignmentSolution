package com.example.employeemanagementservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.example.employeemanagementservice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByUsernameIgnoreCase(String username);

	UserDetails findByUsername(String username);

}
