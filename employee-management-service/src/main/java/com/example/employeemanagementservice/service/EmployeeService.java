package com.example.employeemanagementservice.service;

import java.util.List;
import java.util.Map;

import com.example.employeemanagementservice.entity.Employee;

public interface EmployeeService {

	Employee addEmployee(Employee employee);

	List<Employee> fetchAllEmployees();

	Employee getEmployeeById(long id);

	Employee updateEmployeeDetailsIfPresent(Employee employee);

	String deleteEmployeeIfPresent(long id);

	List<Employee> fetchEmployeeWithFirstName(String firstName);

	Map<String, Object> getEmployeeSortedByFirstName(String order);

}
