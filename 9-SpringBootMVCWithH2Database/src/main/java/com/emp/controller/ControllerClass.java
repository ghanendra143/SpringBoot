package com.emp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.emp.dao.EmpRepo;
import com.emp.model.Employee;

@Controller
public class ControllerClass {
	@Autowired
	EmpRepo empRepo;

	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@RequestMapping("/add")
	public String signup() {
		return "add";
	}

	@RequestMapping("/regDone")
	public String regDone(@ModelAttribute Employee employee) {
		empRepo.save(employee);
		return "regDone";
	}

	@RequestMapping("/update")
	public String update() {
		return "update";
	}

	@RequestMapping("/updateSuccess")
	public String updateSuccess(@ModelAttribute Employee employee) {
		Optional<Employee> opt = empRepo.findById(employee.getEmp_id());
		empRepo.save(employee);
		return "updateSuccess";
	}

	@RequestMapping("/delete")
	public String deleteEmp() {
		return "delete";
	}

//	@RequestMapping("/deleteSuccess")
//	public String deleteSuccess(@ModelAttribute Employee employee)
//	{
//		Optional<Employee> opt =empRepo.findById(employee.getEmp_id());
//		empRepo.delete(employee);
//		return"deleteSuccess";
//	}

	@RequestMapping("/deleteSuccess")
	public String deleteSuccess(@RequestParam("emp_id") int id, Model model) {
		model.addAttribute("empid", id);
		empRepo.deleteById(id);
		return "deleteSuccess";
	}

	@RequestMapping("/viewOne")
	public String viewOne() {
		return "viewOne";
	}

	@RequestMapping("/viewOneSuccess")
	public String viewOneSuccess(@RequestParam("emp_id") int id, Model model) {
		Optional<Employee> opt = empRepo.findById(id);
		Employee emp = opt.get();
		model.addAttribute("emp", emp);
		System.out.println(emp);
		return "viewOneSuccess";
	}

	@RequestMapping("/viewAll")
	public String viewAll(Model model) {
		List<Employee> list = (List<Employee>) empRepo.findAll();
		for(Employee e:list)
		{
			System.out.println(e.getEmp_id());
			System.out.println(e.getEmp_name());
			System.out.println(e.getAddress());
			System.out.println(e.getSalary());
		}
		model.addAttribute("emplist", list);
		return "viewAll";
	}

}
