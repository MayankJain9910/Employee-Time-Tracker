package com.employee.timetracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController 
{
	@GetMapping
	public String getHomeView()
	{
		return "home";
	}
}
