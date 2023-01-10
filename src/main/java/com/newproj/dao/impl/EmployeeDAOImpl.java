package com.newproj.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.newproj.dao.EmployeeDAO;
import com.newproj.model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public EmployeeDAOImpl() {
		
	}
	
	public int createTable() {
		String query = "CREATE TABLE IF NOT EXISTS Employee(empId int primary key, name varchar(30), "
				+ "designation varchar(30), salary double, createdAt datetime, updatedAt datetime)";
		int update = this.jdbcTemplate.update(query);
		return update;
	}

	public List<Employee> getAllEmployees() {
		String query = "select * from Employee";
		List<Employee> employees = this.jdbcTemplate.query(query, new BeanPropertyRowMapper(Employee.class));
		return employees;
	}

	public Employee getEmployee(int empId) {
		String query = "select * from Employee where empId=?";
		return (Employee) this.jdbcTemplate.queryForObject(query, new Object[] {empId}, new BeanPropertyRowMapper(Employee.class));
	}

	public int addEmployee(Employee emp) {
		
		List<Employee> allEmployees = this.getAllEmployees();
		
		for(Employee employee: allEmployees) {
			if (Integer.parseInt(emp.getEmpId()) == Integer.parseInt(employee.getEmpId())) {
				System.out.println("Duplicate entry, enter new id");
				return -1;
			}
		}
		
		String query = "insert into Employee(empId, name, designation, salary, createdAt, updatedAt) values(?,?,?,?,?,?)";
		
		Date date = new Date();
		Date updatedAt = new Date(date.getTime());
		
		int update = this.jdbcTemplate.update(query, new Object[] {emp.getEmpId(), emp.getName(), emp.getDesignation(), emp.getSalary(), updatedAt, updatedAt});
		return update;
	}

	public int updateEmployee(Employee emp) {
		List<Employee> allEmployees = this.getAllEmployees();
		
		for(Employee employee: allEmployees) {
			if (Integer.parseInt(emp.getEmpId()) == Integer.parseInt(employee.getEmpId())) {
				
				Date date = new Date();
				Date updatedAt = new Date(date.getTime());
				
				String query = "update Employee set name=?, designation=?, salary=?, updatedAt=? where empId=?";
				int update=this.jdbcTemplate.update(query, new Object[] {emp.getName(), emp.getDesignation(), emp.getSalary(), updatedAt, emp.getEmpId()});
				return update;
			}
		}
		
		return -1;
	}
	
	
	public int deleteEmployee(int empId) {
		String query = "delete from Employee where empId=?";
		int update = this.jdbcTemplate.update(query, empId);
		return update;
		
	}
}
