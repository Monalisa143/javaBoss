package com.nt.test;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.nt.config.AppConfig;
import com.nt.dto.EmployeeDto;
import com.nt.service.EmployeeMgmtService;
import com.nt.service.EmplyeeMgmtServiceImpl;

@SpringBootApplication
@Import(AppConfig.class)
public class SpringDataProj1Application {

	public static void main(String[] args) {
		EmployeeDto dto2=null;
		ApplicationContext ctx = null;
		EmployeeMgmtService service = null;
		List listDto = null;
		ctx = SpringApplication.run(SpringDataProj1Application.class, args);
		service = (EmployeeMgmtService) ctx.getBean("EmployeeService", EmplyeeMgmtServiceImpl.class);
		// invoke the method
		System.out.println(service.getAllEmp());
		System.out.println("............................");
		System.out.println(service.getEmployeeById(104));
		System.out.println(".........................");
		System.out.println("desg records:"+service.getEmployeeByDesg("Faculty", "clerk"));
		System.out.println("................");
		System.out.println(service.getEmployeeByCount());
		System.out.println(".................");
		System.out.println("get all salaries: "+service.getEmployeeSalaries());
		System.out.println("................");
		
		try {
			dto2=new EmployeeDto();
			//dto2.setEid(101);
			dto2.setEname("bimal");
			dto2.setDesg("sp");
			dto2.setSalary(5000000);
			
			System.out.println("registration checking: "+service.registerEmployee(dto2));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			System.out.println("Update Result: "+service.addBonousEmployeeDesgBySal("clerk", 23444));
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		
		((ConfigurableApplicationContext) ctx).close();

	}

	
}