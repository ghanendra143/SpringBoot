package com.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Phone;

public interface PhoneRepository extends JpaRepository<Phone, Integer>{

}
