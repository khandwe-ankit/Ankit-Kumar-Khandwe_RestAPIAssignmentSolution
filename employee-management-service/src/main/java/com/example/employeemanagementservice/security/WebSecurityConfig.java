package com.example.employeemanagementservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.employeemanagementservice.serviceImpl.DomainUserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		        .authorizeRequests()
		        /* Keeping user & role end points open so this can be added */
		        .antMatchers("/user/**", "/role/**", "/login**", "/login/**", "/logout**", "/h2-console/**")
		        .permitAll();
//		        .antMatchers(HttpMethod.POST, "/user/**", "/role/**")
//		        .permitAll()

		http.authorizeRequests()
		        .antMatchers(HttpMethod.GET, "/employee**", "/employee/**")
		        .hasAnyAuthority("USER", "ADMIN")
//		        .hasAnyRole("USER", "ADMIN")
		        .antMatchers(HttpMethod.POST, "/employee/**")
		        .hasAuthority("ADMIN")
//		        .hasRole("ADMIN")
		        .antMatchers(HttpMethod.PUT, "/employee/**")
		        .hasAuthority("ADMIN")
//		        .hasRole("ADMIN")
		        .antMatchers(HttpMethod.DELETE, "/employee/**")
		        .hasAuthority("ADMIN")
//		        .hasRole("ADMIN")
		        .anyRequest().authenticated()
		        .and().formLogin()
		        .and().httpBasic()
		        .and()
		        .cors().disable()
		        .csrf().disable()
		        .headers().frameOptions().disable();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailService());
		authenticationProvider.setPasswordEncoder(getPasswordEncoder());
		return authenticationProvider;
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailService() {
		return new DomainUserDetailsServiceImpl();
	}
}
