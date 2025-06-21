package com.employee.timetracker.user.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.employee.timetracker.user.entities.TimeInfo;
public interface TimeInfoRepository extends JpaRepository<TimeInfo,Integer>
{
	@Query("from TimeInfo where empId=:arg1 and intime=:arg2")
	TimeInfo getTimeinfo(@Param("arg1") int empId,@Param("arg2") String intime);

	@Query("from TimeInfo where date=:arg")
	List<TimeInfo> findAllSpecifiedDate(@Param("arg") LocalDate date);

	@Query("from TimeInfo where date between :arg1 and :arg2")
	List<TimeInfo> findAllBetweenDate(@Param("arg1") LocalDate date1,@Param("arg2") LocalDate date2);

	@Query("from TimeInfo where date=:arg1 and empId=:arg2")
	List<TimeInfo> findAllSpecifiedDate(@Param("arg1") LocalDate date,@Param("arg2") int empId);

	@Query("from TimeInfo where date between :arg1 and :arg2 and empId=:arg3")
	List<TimeInfo> findAllBetweenDate(@Param("arg1")LocalDate date1,@Param("arg2")LocalDate date2,@Param("arg3") int empId);
}
