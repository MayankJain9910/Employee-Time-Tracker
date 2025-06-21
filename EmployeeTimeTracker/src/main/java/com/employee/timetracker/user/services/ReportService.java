package com.employee.timetracker.user.services;

import java.time.LocalDate;
import java.util.List;

import com.employee.timetracker.user.entities.TimeInfo;

public interface ReportService 
{
	List<TimeInfo> getSpecifiedDateReport(LocalDate now);
	List<TimeInfo> getBetweenDateReport(LocalDate ldate1, LocalDate ldate2);
	List<TimeInfo> getSpecifiedDateReport(LocalDate now, int empId);
	List<TimeInfo> getBetweenDateReport(LocalDate ldate1, LocalDate ldate2, int empId);
}
