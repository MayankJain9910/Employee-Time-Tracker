package com.employee.timetracker.user.controllers;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.employee.timetracker.entities.Employee;
import com.employee.timetracker.repositories.EmployeeRepository;
import com.employee.timetracker.user.entities.TimeInfo;
import com.employee.timetracker.user.services.ReportService;


@Controller
@RequestMapping("user/empwise/report")
public class EmpwiseReportController 
{
	@Autowired private ReportService reportService;
	@Autowired private EmployeeRepository employeeRepository;
	
	@GetMapping("employee-allist")
	public String getEmployeeNameAllList(Model model)
	{
		List<Employee> employeeList=employeeRepository.findAll();
		model.addAttribute("nameList", employeeList);
		return "user/reports/empwise/employee-namelist";
	}
	@GetMapping("currentdate")
	public String getCurrentDateView(Model model,int empId)
	{
		List<TimeInfo> currentDateList=reportService.getSpecifiedDateReport(LocalDate.now(),empId);
		model.addAttribute("currentDateList",currentDateList);
		model.addAttribute("eid",empId);
		return "user/reports/empwise/emp-currentdate-dashboard";
	}
	@GetMapping("anydate")
	public String getAnyDateView(Model model,String date,int empId)
	{
		LocalDate ldate=LocalDate.parse(date);
		List<TimeInfo> anyDateList=reportService.getSpecifiedDateReport(ldate,empId);
		model.addAttribute("anyDateList",anyDateList);
		model.addAttribute("date",ldate);
		model.addAttribute("eid",empId);
		return "user/reports/empwise/emp-anydate-dashboard";
	}
	@GetMapping("between-date")
	public String getBetweenDateView(Model model,String date1,String date2,int empId)
	{
		LocalDate ldate1=LocalDate.parse(date1);
		LocalDate ldate2=LocalDate.parse(date2);
		List<TimeInfo> betweenDateList=reportService.getBetweenDateReport(ldate1,ldate2,empId);
		model.addAttribute("betweenDateList",betweenDateList);
		model.addAttribute("date1",ldate1);
		model.addAttribute("date2",ldate2);
		model.addAttribute("eid",empId);
		return "user/reports/empwise/emp-between-date-dashboard";
	}
}
