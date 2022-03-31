package com.example.employeemanagementservice.serviceImpl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.employeemanagementservice.dao.EmployeeRepository;
import com.example.employeemanagementservice.entity.Employee;
import com.example.employeemanagementservice.exception.EmployeeNotFoundException;
import com.example.employeemanagementservice.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		return this.employeeRepository.save(employee);
	}

	@Override
	public List<Employee> fetchAllEmployees() {
		return this.employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {
		return this.employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(
		        "Employee not found with id: " + id));
	}

	@Override
	public Employee updateEmployeeDetailsIfPresent(Employee employee) {
		Employee emp = this.getEmployeeById(employee.getId());
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		emp.setEmail(employee.getEmail());
		return this.employeeRepository.save(emp);
	}

	@Override
	public String deleteEmployeeIfPresent(long id) {
		Employee employee = getEmployeeById(id);
		this.employeeRepository.delete(employee);
		return "Deleted employee id - " + id;
	}

	@Override
	public List<Employee> fetchEmployeeWithFirstName(String firstName) {
		return this.employeeRepository.findByFirstNameIgnoreCase(firstName);
	}

	@Override
	public Map<String, Object> getEmployeeSortedByFirstName(String order) {
		Direction direction = order.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;

		List<Employee> empList = this.employeeRepository.findAll(Sort.by(direction, "firstName"));
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("Sorted-employee-list", empList);
		return map;

	}

}
