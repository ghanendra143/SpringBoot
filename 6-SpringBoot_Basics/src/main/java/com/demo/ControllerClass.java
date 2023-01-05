package com.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControllerClass {

	@RequestMapping("/home")
	public String home()
	{
		return "hello";
	}
	
	@RequestMapping("/details")
	public String demo(@RequestParam("name") String name, @RequestParam("age") int age,
			@RequestParam("address") String add, Model model)
	{
		model.addAttribute("name",name);
		model.addAttribute("age",age);
		model.addAttribute("address",add);		
		return "details";
	}
	
}

