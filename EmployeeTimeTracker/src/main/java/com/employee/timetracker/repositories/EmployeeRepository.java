package com.employee.timetracker.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employee.timetracker.entities.Employee;

import jakarta.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> 
{
	@Query("from Employee where status=:arg")
	List<Employee> findAll(@Param("arg") String status);

	@Modifying
	@Transactional
	@Query("update Employee set status=:arg1 where empId=:arg2")
	void updateStatus(@Param("arg1") String status,@Param("arg2") int empId);
}
