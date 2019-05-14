package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dto.EmployeeDto;
import com.nt.entity.Employee;
import com.nt.repository.EmployeeRepository;

@Service("EmployeeService")
public class EmplyeeMgmtServiceImpl implements EmployeeMgmtService {
	//use repository
	@Autowired
	private EmployeeRepository findrepo;

	@Override
	public List<EmployeeDto> getAllEmp() {
		System.out.println("dao.class::"+findrepo.getClass());
		List<Employee>entity=null;
		
		entity=(List<Employee>)findrepo.findAll();
		//convert list to entity
		List<EmployeeDto> listDto=new ArrayList();
		entity.forEach(emp ->{
			//copy each entity to dto
			EmployeeDto dto=new  EmployeeDto();
			BeanUtils.copyProperties(emp, dto);
			listDto.add(dto);
			
		});
		return listDto;	
	}

	@Override
	public EmployeeDto getEmployeeById(int id) {
		EmployeeDto dto=null;
		Optional<Employee>optEntity=null;
		
		Employee emp=null;
		optEntity=findrepo.findById(id);
		emp=optEntity.get();
		
		//convert entity to dto
		dto=new EmployeeDto();
		BeanUtils.copyProperties(emp,dto);
		return dto;
	}

	
	  @Override 
	  public List<EmployeeDto> getEmployeeByDesg(String desg1, String desg2) {
		  // use repository List<EmployeeDto>listDto=new ArrayList();
	  List<Employee> listEntity=null;
	  List<EmployeeDto>listDto=new ArrayList();
	  listEntity= findrepo.findEmployeeByDesg(desg1,desg2);
	  listEntity.forEach(emp->{
		  EmployeeDto dto=new EmployeeDto();
	  BeanUtils.copyProperties(emp,dto);
	   listDto.add(dto);
	  });
	  
	  
	  return listDto;
	   
	  }

	@Override
	public Long getEmployeeByCount() {
	 long count=0;
		
		//use repository
		count=findrepo.count();
		return count;
	}

	@Override
	public Long getEmployeeSalaries() {
		long salariesTotal=0;
		salariesTotal=findrepo.findEmpsSalariesTotal();
		
		return salariesTotal;
	}

	@Override
	public String registerEmployee(EmployeeDto dto) {
		// user repository
		Employee entity=null;
				entity=new Employee();
		//convert dto to entity
		BeanUtils.copyProperties(dto, entity);
		if(entity!=null)
		return ("registration successful");
		else {
			return("registration not successful");
		}
	}

	@Override
@Transactional(propagation=Propagation.REQUIRED)	
	public String addBonousEmployeeDesgBySal(String job, float salary) {
		// use repository
		int count;
		count=findrepo.updateBonousDesgWithSalary(job, salary);
		if(count==0)
			return "Update not Success";
		else
			
		return "Update is success";
	}
	   

}
