package com.employee.timetracker.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.timetracker.entities.User;
import com.employee.timetracker.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService 
{
	@Autowired
	private UserRepository userRepository;

	public List<User> getList() 
	{
		return userRepository.findAll();
	}
	public void createUser(User user) 
	{
		userRepository.save(user);
	}
	public User findUserByUsername(String username) 
	{
		return userRepository.findByUsername(username);
	}
}
