package com.newproj.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.newproj.dao.impl.EmployeeDAOImpl;
import com.newproj.model.Employee;


public interface EmployeeDAO {
	
	public int createTable();

	public List<Employee> getAllEmployees();

	public Employee getEmployee(int empId);

	public int addEmployee(Employee emp);

	public int updateEmployee(Employee emp);
	
	public int deleteEmployee(int empId);
	
}


