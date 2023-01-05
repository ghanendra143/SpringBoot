package com.emp;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.emp.dao.empDao;
import com.emp.model.Employee;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		empDao emp = context.getBean(empDao.class);
		Employee e = new Employee();
		
		// insert emp
//		e.setName("ghanendra");
//		emp.save(e);
		
		// update emp
//		Optional<Employee> opt = emp.findById(3);
//		e = opt.get();
//		e.setName("vivek");
//		emp.save(e);
//		System.out.println("emp updated");
	
		// fetch one emp 
//		Optional<Employee> opt = emp.findById(4);
//		e = opt.get();
//		System.out.println("emp details are : "+e.getId()+"--"+e.getName());
	
		// fetch all employees 
//		Iterable<Employee> itr = emp.findAll();
//		for(Employee em:itr)
//		{
//			System.out.println(em.getId()+"=="+em.getName());
//		}
		
		// delete by id
		emp.deleteById(5);
		System.out.println("employee deleted");
	}

}
