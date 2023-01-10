package com.secondproj.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.secondproj.dao.StudentDAO;
import com.secondproj.model.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public StudentDAOImpl () {
		
	}
	
	public int createTable() {
		String query = "CREATE TABLE IF NOT EXISTS Student(stdId int primary key, name varchar(30), "
				+ "subject varchar(30), marks double, createdAt datetime, updatedAt datetime)";
		int update = this.jdbcTemplate.update(query);
		return update;
	}

	public List<Student> getAllStudents() {
		String query = "select * from Student";
		List<Student> students = this.jdbcTemplate.query(query, new BeanPropertyRowMapper(Student.class));
		return students;
	}

	public Student getStudent(int stdId) {
		String query = "select * from Student where stdId=?";
		return (Student) this.jdbcTemplate.queryForObject(query, new Object[] {stdId}, new BeanPropertyRowMapper(Student.class));
	}

	public int addStudent(Student std) {
		
		List<Student> allStudents = this.getAllStudents();
		
		for(Student student: allStudents) {
			if (Integer.parseInt(std.getStdId()) == Integer.parseInt(student.getStdId())) {
				System.out.println("Duplicate entry, enter new id");
				return -1;
			}
		}
		
		String query = "insert into Student(stdid, name, subject, marks, createdAt, updatedAt) values(?,?,?,?,?,?)";
		
		Date date = new Date();
		Date updatedAt = new Date(date.getTime());
		
		int update = this.jdbcTemplate.update(query, new Object[] {std.getStdId(), std.getName(), std.getSubject(), std.getMarks(), updatedAt, updatedAt});
		return update;
		
	}

	public int updateStudent(Student std) {
		List<Student> allStudents = this.getAllStudents();
		
		for(Student student: allStudents) {
			if (Integer.parseInt(std.getStdId()) == Integer.parseInt(student.getStdId())) {
				
				Date date = new Date();
				Date updatedAt = new Date(date.getTime());
				
				String query = "update Student set name=?, subject=?, marks=?, updatedAt=? where stdId=?";
				int update=this.jdbcTemplate.update(query, new Object[] {std.getName(), std.getSubject(), std.getMarks(), updatedAt, std.getStdId()});
				return update;
			}
		}
		
		return -1;
	}
	
	public int deleteStudent(int stdId) {
		String query = "delete from Student where stdId=?";
		int update = this.jdbcTemplate.update(query, stdId);
		return update;
			
	}
}
