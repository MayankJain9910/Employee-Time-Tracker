package com.employee.timetracker.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.timetracker.admin.repositories.DepartmentRepository;
import com.employee.timetracker.admin.repositories.RoleRepository;
import com.employee.timetracker.entities.Employee;
import com.employee.timetracker.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService 
{
	//@Autowired private RoleRepository roleRepository;
	//@Autowired private DepartmentRepository departmentRepository;
	private EmployeeRepository employeeRepository;
	//Dependency injection
	public EmployeeServiceImpl(EmployeeRepository employeeRepository)
	{
		this.employeeRepository=employeeRepository;
	}
	public void saveEmployee(Employee employee) 
	{
		employeeRepository.save(employee);
	}
	public List<Employee> getList() 
	{
		return employeeRepository.findAll();
	}
	public void deleteEmployee(int eid) 
	{
		employeeRepository.deleteById(eid);
	}
	public Map<String, String> getEmployeeByIdEdit(int eid) 
	{
		Employee emp=employeeRepository.findById(eid).orElse(null);
		Map<String,String> map=getEmployeeById(emp);
		//map.put("department",departmentRepository.getDepartment(emp.getDeptId()));
		//map.put("role",roleRepository.getRole(emp.getRoleId()));
		return map;
		
	}
	private Map<String, String> getEmployeeById(Employee emp) 
	{
		
		Map<String,String> map=new HashMap<>();
		if(emp==null)
			map.put("msg","Employee does not exist");
		else
		{
			map.put("firstname",emp.getFirstname());
			map.put("lastname",emp.getLastname());
			map.put("email",emp.getEmail());
			map.put("phone",emp.getPhone());
			map.put("department",String.valueOf(emp.getDeptId()));
			map.put("role",String.valueOf(emp.getRoleId()));
		}
		return map;
	}
}
