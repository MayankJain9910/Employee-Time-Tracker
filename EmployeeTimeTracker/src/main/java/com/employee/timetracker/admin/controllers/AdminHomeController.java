package com.employee.timetracker.admin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminHomeController 
{
	@GetMapping("/home")
	public String getHomeView()
	{
		return "admin/home/admin-home";
	}
	@GetMapping("/login")
	public String getLoginformView()
	{
		return "admin/home/admin-login-form";
	}
	@PostMapping("/login.do")
	public String authenticateAdmin(String userid,String password,Model model)
	{
		if(!userid.equals("admin"))
		{
			model.addAttribute("msg","Entered admin id does not exist");
			model.addAttribute("aid",userid);
			return "admin/home/admin-login-form";	
		}
		if(!password.equals("cetpa"))
		{
			model.addAttribute("msg","Entered password is wrong");
			model.addAttribute("aid",userid);
			return "admin/home/admin-login-form";	
		}
		return "redirect:home";
	}
}
