package com.employee.timetracker.user.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.timetracker.user.entities.TimeInfo;
import com.employee.timetracker.user.repositories.TimeInfoRepository;

@Service
public class ReportServiceImpl implements ReportService 
{
	@Autowired private TimeInfoRepository timeInfoRepository;

	public List<TimeInfo> getSpecifiedDateReport(LocalDate date) 
	{
		return timeInfoRepository.findAllSpecifiedDate(date);
	}

	public List<TimeInfo> getBetweenDateReport(LocalDate date1, LocalDate date2) 
	{
		return timeInfoRepository.findAllBetweenDate(date1,date2);
	}

	public List<TimeInfo> getSpecifiedDateReport(LocalDate date, int empId) 
	{
		return timeInfoRepository.findAllSpecifiedDate(date,empId);
	}

	public List<TimeInfo> getBetweenDateReport(LocalDate date1, LocalDate date2, int empId) 
	{
		return timeInfoRepository.findAllBetweenDate(date1,date2,empId);
	}
	
}
