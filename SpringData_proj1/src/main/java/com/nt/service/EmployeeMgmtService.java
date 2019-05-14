package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDto;
import com.nt.entity.Employee;

public interface EmployeeMgmtService {
	public List<EmployeeDto>getAllEmp();
	public EmployeeDto getEmployeeById(int id);
	public List<EmployeeDto> getEmployeeByDesg(String desg1,String desg2);
    public Long getEmployeeByCount();
    public Long getEmployeeSalaries();
    public String registerEmployee(EmployeeDto dto);
    public String addBonousEmployeeDesgBySal(String job,float salary);
}
 