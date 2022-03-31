package com.example.employeemanagementservice.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.employeemanagementservice.dao.UserRepository;
import com.example.employeemanagementservice.entity.User;
import com.example.employeemanagementservice.security.MyUserDetails;

@Service
public class DomainUserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userRepository.findByUsernameIgnoreCase(username);
		if (user != null) {
			System.out.println(user);
			return new MyUserDetails(user);
		} else
			throw new UsernameNotFoundException("Username " + username + ", not found!");
	}

}
