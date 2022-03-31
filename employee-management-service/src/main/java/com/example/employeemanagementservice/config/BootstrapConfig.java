package com.example.employeemanagementservice.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

import com.example.employeemanagementservice.dao.EmployeeRepository;
import com.example.employeemanagementservice.entity.Employee;
import com.github.javafaker.Faker;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class BootstrapConfig implements ApplicationListener<ApplicationReadyEvent> {

	private final Faker faker = new Faker();
	private final EmployeeRepository employeeRepository;
//	private PasswordEncoder passwordEncoder;

	public BootstrapConfig(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		log.info("=========Application-initialized==========");

		for (int i = 0; i < 100; i++) {
			Employee employee = new Employee(
			        faker.name().firstName(), faker.name().lastName(), faker.internet().emailAddress());
			employeeRepository.save(employee);
		}
//		String encodedPassword = this.passwordEncoder.encode("admin");
//		Role role = new Role("SUPERADMIN");
//		User user = new User("Admin", null, null)
		log.info("=========Application-initialized==========");
	}

}
