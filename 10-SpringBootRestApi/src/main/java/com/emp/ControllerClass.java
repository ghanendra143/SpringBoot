package com.emp;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class ControllerClass {

	@GetMapping(path="/get/{id}")
	public String getUser(@PathVariable int id) {
		return "GET request is called and id is : "+id;
	}
	
	@GetMapping
	public String getStudent(@RequestParam(value="sname") String sname,
			@RequestParam(value="rollno") int roll) {
		return "student name : "+sname+"\nroll no : "+roll; 
	}
	
	@DeleteMapping(path="/delete")
	public String deleteUser() {
		return "DELETE request is called";
	}
	
	@PutMapping(path="/put")
	public String putUser() {
		return "PUT request is called";
	}
	
	@PostMapping(path="/post")
	public String postUser() {
		return "POST request is called";
	}
	
}
