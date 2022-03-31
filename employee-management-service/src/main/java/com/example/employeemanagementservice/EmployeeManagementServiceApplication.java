package com.example.employeemanagementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
@SpringBootApplication
public class EmployeeManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementServiceApplication.class, args);
	}

}
