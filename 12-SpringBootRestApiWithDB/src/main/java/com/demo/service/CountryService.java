package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.demo.controller.AddResponse;
import com.demo.pojo.Country;
import com.demo.repo.CountryRepository;

@Component 
@Service
public class CountryService {
	
	@Autowired
	CountryRepository cr;
	
	public List<Country> getAllCountries() {
		return cr.findAll();
	}
	
	public Country getCountryById(int id) {
		return cr.findById(id).get();
	}
	
	public Country getCountryByName(String countryName) {
		Country country = null;
		List<Country> countries = cr.findAll();
		for (Country c : countries) {
			if(c.getCountryName().equalsIgnoreCase(countryName)) {
				country = c;
			}
		}
		return country;
	}
	
	// method to create next id
	public int getMaxId() {
		return cr.findAll().size()+1;
	}
	
	public Country addCountry(Country country) {
		country.setId(getMaxId());
		cr.save(country);
		return country;
	}
	
	public Country updateCountry(Country country) {
		cr.save(country);
		return country;
	}
	
	public AddResponse deleteCountry(int id) {
		cr.deleteById(id);
		AddResponse res = new AddResponse();
		res.setMsg("Country Deleted!!");
		res.setId(id);
		return res;
	}
}
