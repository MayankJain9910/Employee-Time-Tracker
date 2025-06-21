package com.employee.timetracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.timetracker.entities.User;

public interface UserRepository extends JpaRepository<User,Integer> 
{
	User findByUsername(String username);
}
