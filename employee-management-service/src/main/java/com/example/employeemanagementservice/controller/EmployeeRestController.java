package com.example.employeemanagementservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.employeemanagementservice.entity.Employee;
import com.example.employeemanagementservice.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping
	public Employee addEmployee(@RequestBody Employee employee) {
		return this.employeeService.addEmployee(employee);
	}

	@GetMapping
	public List<Employee> fetchAllEmployees() {
		return this.employeeService.fetchAllEmployees();
	}

	@GetMapping("/{id}")
	public Employee findEmployeeById(@PathVariable long id) {
		return this.employeeService.getEmployeeById(id);
	}

	@PutMapping
	public Employee updateEmployeeDetails(@RequestBody Employee employee) {
		return this.employeeService.updateEmployeeDetailsIfPresent(employee);

	}

	@DeleteMapping("/{id}")
	public String deleteEmployee(@PathVariable long id) {
		return this.employeeService.deleteEmployeeIfPresent(id);
	}

	@GetMapping("/searchByFirstName/{firstName}")
	public List<Employee> searchEmployeeWithFirstName(@PathVariable String firstName) {
		return this.employeeService.fetchEmployeeWithFirstName(firstName);
	}

	@GetMapping("/sort")
	public Map<String, Object> fetchEmployeeSortedByFirstName(@RequestParam String order) {
		return this.employeeService.getEmployeeSortedByFirstName(order);
	}
}
