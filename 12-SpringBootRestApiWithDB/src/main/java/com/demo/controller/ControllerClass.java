package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<Country> getCountryById(@PathVariable(value="id") int id) {
		try {
			Country country = cs.getCountryById(id);
			return new ResponseEntity<Country>(country, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//  http://localhost:8080/getcountries/countryName?countryName=india
	@GetMapping("/getcountries/countryName")
	public ResponseEntity<Country> getCountryByName(@RequestParam(value="countryName") String countryName) {
		try {
			Country country = cs.getCountryByName(countryName);
			return new ResponseEntity<Country>(country, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//  http://localhost:8080/addcountry
	@PostMapping("/addcountry")
	public Country addCountry(@RequestBody Country country) {
		return cs.addCountry(country);
	}
	
	//  http://localhost:8080/updatecountry
	@PutMapping("/updatecountry/{id}") 
	public ResponseEntity<Country> updateCountry(@PathVariable(value="id") int id, @RequestBody Country country) {
		try {
			Country existcountry = cs.getCountryById(id);
			existcountry.setCountryName(country.getCountryName());
			existcountry.setCountryCapital(country.getCountryCapital());
			Country updated_country = cs.updateCountry(existcountry);
			return new ResponseEntity<Country>(updated_country, HttpStatus.OK);
		} 
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}  
	}
	
	//  http://localhost:8080/deletecountry/6
	@DeleteMapping("/deletecountry/{id}")
	public AddResponse deleteCountry(@PathVariable(value="id") int id) {
		return cs.deleteCountry(id);
	}
}
