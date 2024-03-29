package com.thanh.springboot.cruddemo.service;

import java.util.List;

import com.thanh.springboot.cruddemo.entity.Employee;

public interface EmployeeService {
	public List<Employee> findAll();

	public Employee findById(int theId);

	public Employee save(Employee theEmployee);

	public void deleteById(int theId);
}
