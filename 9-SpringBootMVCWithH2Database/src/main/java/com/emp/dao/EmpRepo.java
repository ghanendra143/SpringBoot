package com.emp.dao;

import org.springframework.data.repository.CrudRepository;

import com.emp.model.Employee;

public interface EmpRepo extends CrudRepository<Employee, Integer>{

}
