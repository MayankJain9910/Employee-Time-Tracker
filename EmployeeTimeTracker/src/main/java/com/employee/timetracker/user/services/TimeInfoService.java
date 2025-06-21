package com.employee.timetracker.user.services;

import com.employee.timetracker.user.entities.TimeInfo;

public interface TimeInfoService 
{
	void saveTimeOut(TimeInfo timeInfo);
	//void updateTimeIn(int empId);

	void updateTimeIn(int empId);
}
