package com.nt.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nt.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
	@Query("from Employee where desg in(:job1,:job2)")
	public List<Employee> findEmployeeByDesg(@Param("job1")String desg1,@Param("job2")String desg2);
	
	@Query("Select sum(desg) from Employee")
	public long findEmployeesAllCount();
	@Query("select sum(salary) from  Employee")
	public   long  findEmpsSalariesTotal();
	
	@Query("update Employee  set salary=salary+:bns where desg=:job")
	@Modifying
	public int updateBonousDesgWithSalary(@Param("job")String job1,@Param("bns")float salary);
}
