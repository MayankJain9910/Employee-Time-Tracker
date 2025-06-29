package com.employee.timetracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class EmployeeTimeTrackerApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(EmployeeTimeTrackerApplication.class, args);
	}
	@Bean
	BCryptPasswordEncoder getPasswordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
}
