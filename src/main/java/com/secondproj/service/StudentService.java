package com.secondproj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secondproj.dao.StudentDAO;
import com.secondproj.model.Student;
import com.secondproj.service.impl.StudentServiceImpl;

public interface StudentService {
	
	public List<Student> getAllStudents();

	public Student getStudent(int stdId);

	public String addStudent(Student std);
	
	public String deleteStudent(int stdId);

	public String addAllStudents(List<Student> stds);
	
	public String updateStudent(Student std);
	
}
