package com.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.pojo.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {
	
}
