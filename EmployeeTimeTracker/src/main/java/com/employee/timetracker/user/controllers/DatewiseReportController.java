package com.employee.timetracker.user.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.employee.timetracker.user.entities.TimeInfo;
import com.employee.timetracker.user.services.ReportService;

@Controller
@RequestMapping("user/datewise/report")
public class DatewiseReportController 
{
	@Autowired private ReportService reportService;
	
	@GetMapping("currentdate")
	public String getCurrentDateView(Model model)
	{
		List<TimeInfo> currentDateList=reportService.getSpecifiedDateReport(LocalDate.now());
		model.addAttribute("currentDateList",currentDateList);
		return "user/reports/datewise/currentdate-dashboard";
	}
	@GetMapping("anydate")
	public String getAnyDateView(Model model,String date)
	{
		LocalDate ldate=LocalDate.parse(date);
		List<TimeInfo> anyDateList=reportService.getSpecifiedDateReport(ldate);
		model.addAttribute("anyDateList",anyDateList);
		model.addAttribute("date",ldate);
		return "user/reports/datewise/anydate-dashboard";
	}
	@GetMapping("between-date")
	public String getBetweenDateView(Model model,String date1,String date2)
	{
		LocalDate ldate1=LocalDate.parse(date1);
		LocalDate ldate2=LocalDate.parse(date2);
		List<TimeInfo> betweenDateList=reportService.getBetweenDateReport(ldate1,ldate2);
		model.addAttribute("betweenDateList",betweenDateList);
		model.addAttribute("date1",ldate1);
		model.addAttribute("date2",ldate2);
		return "user/reports/datewise/between-date-dashboard";
	}
}
