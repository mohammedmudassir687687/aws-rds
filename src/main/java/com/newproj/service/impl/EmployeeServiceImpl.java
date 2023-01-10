package com.newproj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newproj.dao.EmployeeDAO;
import com.newproj.dao.impl.EmployeeDAOImpl;
import com.newproj.model.Employee;
import com.newproj.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDAOImpl empdao;
	
	public EmployeeServiceImpl() {
		
	}
	
	public List<Employee> getAllEmployees() {
		return empdao.getAllEmployees();
	}

	public Employee getEmployee(int empId) {
		
		return empdao.getEmployee(empId);
	}

	public String addEmployee(Employee emp) {
		int update = empdao.addEmployee(emp);
		if (update == -1) {
			return "Duplicate entry, enter new empId";
		}
		return "New Employee added into the database: " + emp.getEmpId() + ": " + emp.getName();
	}
	
	public String updateEmployee(Employee emp) {
		int update = empdao.updateEmployee(emp);
		if (update == -1) {
			return "Employee not found";
		}
		return "Employee updated into the database: " + emp.getEmpId();
	}
	
	public String deleteEmployee(int empId) {
		empdao.deleteEmployee(empId);
		return "Employee deleted from the database: " + empId;
	}

	public String addAllEmployees(List<Employee> emps) {
//		daolayer.add
		return "All employees added into the database";
	}


}
