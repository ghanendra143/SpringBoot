package com.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.demo.controller.AddResponse;
import com.demo.pojo.Country;

@Component 
public class CountryService {
	
	static HashMap<Integer, Country> countryIdMap;
	
	public CountryService() {
		countryIdMap = new HashMap<Integer, Country>();
		Country ind = new Country(1,"India","New Deldi");
		Country usa = new Country(2,"America","washington dc");
		Country uk = new Country(3,"England","london");
		
		countryIdMap.put(1, ind);
		countryIdMap.put(2, usa);
		countryIdMap.put(3, uk);
	}
	
	public List getAllCountries() {
		List countries = new ArrayList(countryIdMap.values());
		return countries;
	}
	
	public Country getCountryById(int id) {
		Country country = countryIdMap.get(id);
		return country;
	}
	
	public Country getCountryByName(String countryName) {
		Country country = null;
		for(int i:countryIdMap.keySet()) {
			if(countryIdMap.get(i).getCountryName().equalsIgnoreCase(countryName)) {
				country = countryIdMap.get(i);
			}
		}
		return country;
	}
	
	// method to create next id
	public static int getMaxId() {
		int maxid = 0;
		for(int id:countryIdMap.keySet()) {
			if(maxid<=id) {
				maxid=id;
			}
		}
		return maxid+1;
	}
	
	public Country addCountry(Country country) {
		country.setId(getMaxId());
		countryIdMap.put(country.getId(), country);
		return country;
	}
	
	public Country updateCountry(Country country) {
		if(country.getId()>0) {
			countryIdMap.put(country.getId(), country);
		}
		return country;
	}
	
	public AddResponse deleteCountry(int id) {
		countryIdMap.remove(id);
		AddResponse res = new AddResponse();
		res.setMsg("country deleted");
		res.setId(id);
		return res;
	}

}
