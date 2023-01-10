package com.newproj.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newproj.model.Employee;
import com.newproj.service.impl.EmployeeServiceImpl;


public interface EmployeeService {


	public List<Employee> getAllEmployees();

	public Employee getEmployee(int empId);

	public String addEmployee(Employee emp);
	
	public String updateEmployee(Employee emp);
	
	public String deleteEmployee(int empId);
	
	public String addAllEmployees(List<Employee> emps);
}
