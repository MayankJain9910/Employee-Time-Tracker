package com.employee.timetracker.admin.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employee.timetracker.entities.Role;

public interface RoleRepository extends JpaRepository<Role,Integer>
{
	@Query("from Role where department.deptId=:arg")
	List<Role> findAllByDept(@Param("arg") int deptId);

	@Query("select role from Role where rid=:arg")
	String getRole(@Param("arg") int roleId);
}
