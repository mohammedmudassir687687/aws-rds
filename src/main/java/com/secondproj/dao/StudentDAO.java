package com.secondproj.dao;

import java.util.List;

import com.secondproj.model.Student;

public interface StudentDAO {
	
	public int createTable();

	public List<Student> getAllStudents();

	public Student getStudent(int stdId);

	public int addStudent(Student std);

	public int updateStudent(Student std);
	
	public int deleteStudent(int stdId);
			
		
}

