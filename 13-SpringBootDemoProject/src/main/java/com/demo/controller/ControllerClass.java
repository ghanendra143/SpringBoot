package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Phone;
import com.demo.service.ServiceClass;

@RestController
public class ControllerClass {
	
	@Autowired
	ServiceClass sc;

	@GetMapping("/getallphones")
	public List getAllPhones() {
		return sc.viewAllPhone();
	}
	
	@GetMapping("/getonephone/{id}")
	public Phone getOnePhone(@PathVariable(value="id") int id) {
		Phone phone = sc.viewOnePhone(id);
		return phone;
	}	
	
	@PostMapping("/addphone")
	public Phone addNewPhone(@RequestBody Phone phone) {
		return sc.addPhone(phone);
	}
	
	@PutMapping("/updatePhone/{id}")
	public Phone updatePhone(@RequestBody Phone phone, @PathVariable(value="id") int id) {
		phone.setPhoneId(id);
		return sc.updatePhone(phone);
	}
	
	@DeleteMapping("deletePhone/{id}")
	public String deletePhone(@PathVariable(value="id") int id) {
		sc.deletePhone(id);
		return "phone id : "+id+"\nphone deleted !!";
	}
}
