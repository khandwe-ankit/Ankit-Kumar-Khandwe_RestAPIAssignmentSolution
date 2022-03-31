package com.example.employeemanagementservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.employeemanagementservice.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByNameIgnoreCase(String name);

}
