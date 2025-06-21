package com.employee.timetracker.admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employee.timetracker.entities.Department;

public interface DepartmentRepository extends JpaRepository<Department,Integer>
{
	@Query("select deptName from Department where deptId=:arg")
	String getDepartment(@Param("arg") int deptId);
}