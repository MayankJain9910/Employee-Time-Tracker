package com.employee.timetracker.user.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.timetracker.repositories.EmployeeRepository;
import com.employee.timetracker.user.entities.TimeInfo;
import com.employee.timetracker.user.repositories.TimeInfoRepository;
import com.employee.timetracker.utility.TimeDateUtility;

@Service
public class TimeInfoServiceImpl implements TimeInfoService
{
	@Autowired private TimeInfoRepository timeInfoRepository;
	@Autowired private EmployeeRepository employeeRepository;

	public void saveTimeOut(TimeInfo timeInfo) 
	{
		//Saving timeInfo object into database 
		timeInfo.setOutime(TimeDateUtility.getCurrentTime());
		timeInfo.setDate(LocalDate.now());
		timeInfoRepository.save(timeInfo);
		
		//Updating employee status as out into Employee object 
		employeeRepository.updateStatus("out",timeInfo.getEmpId());
	}
	public void updateTimeIn(int empId) 
	{
		//Getting TimeInfo object from database
		TimeInfo timeInfo=timeInfoRepository.getTimeinfo(empId,"Not in yet");
		//Setting inttime and totaltime in timeInfo object 
		String intime=TimeDateUtility.getCurrentTime();
		String totaltime=TimeDateUtility.getTotalTime(timeInfo.getOutime(),intime);
		timeInfo.setIntime(intime);
		timeInfo.setTotaltime(totaltime);
		//Updating timeInfo object into database 
		timeInfoRepository.save(timeInfo);
		
		//Updating employee status as in into Employee object 
		employeeRepository.updateStatus("in",empId);
	}
}
