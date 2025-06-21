package com.employee.timetracker.services;

import java.util.List;
import java.util.Map;

import com.employee.timetracker.entities.Employee;

public interface EmployeeService 
{
	void saveEmployee(Employee employee);
	List<Employee> getList();
	void deleteEmployee(int eid);
	Map<String, String> getEmployeeByIdEdit(int eid);
}
