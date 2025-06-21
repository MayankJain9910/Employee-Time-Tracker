package com.employee.timetracker.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.employee.timetracker.entities.User;
import com.employee.timetracker.services.UserService;

import jakarta.servlet.http.HttpSession;


@Controller
@RequestMapping("user")
public class UserHomeController 
{
	@Autowired private UserService userService;
	@Autowired private BCryptPasswordEncoder passwordEncoder;
	
	@GetMapping("login")
	public String getLoginView()
	{
		return "user/home/user-login-form";
	}
	@PostMapping("login.do")
	public String authenticateUser(String userid,String password,Model model,HttpSession session)
	{
		User user=userService.findUserByUsername(userid);
		if(user==null)
		{
			model.addAttribute("msg","Entered userid does not exist");
			model.addAttribute("uid", userid);
			return "user/home/user-login-form";
		}
		String dpassword=user.getPassword();
		if(!passwordEncoder.matches(password,dpassword))
		{
			model.addAttribute("msg","Entered password is wrong");
			model.addAttribute("uid", userid);
			return "user/home/user-login-form";
		}
		session.setAttribute("name",user.getFirstname()+" "+user.getLastname());
		return "redirect:home";
	}
	@GetMapping("home")
	public String getAdminHomeView(Model model)
	{
		model.addAttribute("msg","Welcome to the User Home Panel");
		return "user/home/user-home";
	}
	@GetMapping("logout")
	public String getLogoutView(Model model,HttpSession session)
	{
		model.addAttribute("name",session.getAttribute("name"));
		session.invalidate();
		return "user/home/logout-success";
	}
}
