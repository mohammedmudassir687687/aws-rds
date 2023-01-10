package com.newproj.controller;

//import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.newproj.model.Employee;
import com.newproj.service.impl.EmployeeServiceImpl;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImpl empservice;

	@GetMapping(value = "/")
	public String homePage() {	
		return "welcome to real world training";
	}
	
	@GetMapping("/employees")
	public List<Employee> createList() {
		
		return empservice.getAllEmployees();
	}
	
	@GetMapping(path = { "/employees/{id}" })
	public Employee getEmp(@PathVariable("id") int id) {
		
		return empservice.getEmployee(id);

	}
	
	@PostMapping(path = {"/employees"})
	public String create(@RequestBody Employee user) {
		
		return empservice.addEmployee(user);

	}
	
	@PutMapping(path = {"/employees"})
	public String update(@RequestBody Employee user) {
		return empservice.updateEmployee(user);
	}

	@DeleteMapping(path = { "/employees/{id}" })
	public String delete(@PathVariable("id") int id) {
		
		return empservice.deleteEmployee(id);
		
	}
	



}
