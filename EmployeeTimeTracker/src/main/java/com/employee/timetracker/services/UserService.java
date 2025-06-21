package com.employee.timetracker.services;

import java.util.List;

import com.employee.timetracker.entities.User;

public interface UserService 
{
	List<User> getList();
	void createUser(User user);
	User findUserByUsername(String username);
}
