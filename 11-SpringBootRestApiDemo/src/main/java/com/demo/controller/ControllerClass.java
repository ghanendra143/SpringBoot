package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.pojo.Country;
import com.demo.service.CountryService;

@RestController
public class ControllerClass {
	
	@Autowired
	CountryService cs;
	
	//  http://localhost:8080/getcountries
	@GetMapping("/getcountries")
	public List getCountries() {
		return cs.getAllCountries();
	}
	
	//  http://localhost:8080/getcountries/2
	@GetMapping("/getcountries/{id}")
	public Country getCountryById(@PathVariable(value="id") int id) {
		return cs.getCountryById(id);
	}
	
	//  http://localhost:8080/getcountries/countryName?countryName=india
	@GetMapping("/getcountries/countryName")
	public Country getCountryByName(@RequestParam(value="countryName") String countryName) {
		return cs.getCountryByName(countryName);
	}
	
	//  http://localhost:8080/addcountry
	@PostMapping("/addcountry")
	public Country addCountry(@RequestBody Country country) {
		return cs.addCountry(country);
	}
	
	//  http://localhost:8080/updatecountry
	@PutMapping("/updatecountry") 
	public Country updateCountry(@RequestBody Country country) {
		return cs.updateCountry(country);
	}
	
	//  http://localhost:8080/deletecountry/6
	@DeleteMapping("/deletecountry/{id}")
	public AddResponse deleteCountry(@PathVariable(value="id") int id) {
		return cs.deleteCountry(id);
	}
}
