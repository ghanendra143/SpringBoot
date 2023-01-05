package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.demo.model.Phone;
import com.demo.repo.PhoneRepository;

@Component
@Service
public class ServiceClass {
	
	@Autowired
	PhoneRepository pr;
		
	public Phone viewOnePhone(int id) {
		return pr.findById(id).get();
	}
	
	public List<Phone> viewAllPhone() {
		List<Phone> allPhones =  pr.findAll();
		return allPhones;
	}
	
	public Phone addPhone(Phone phone) {
		pr.save(phone);
		return phone;
	}
	
	public Phone updatePhone(Phone phone) {
		pr.save(phone);
		return phone;
	}
	
	public Phone deletePhone(int id) {
		Phone phone = null;
		pr.deleteById(id);
		return phone;
	}
}
