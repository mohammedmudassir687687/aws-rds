package com.secondproj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.secondproj.dao.impl.StudentDAOImpl;
import com.secondproj.model.Student;
import com.secondproj.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDAOImpl studentdao;
	
	public StudentServiceImpl() {
		
	}
	
	public List<Student> getAllStudents() {
		return studentdao.getAllStudents();
	}

	public Student getStudent(int stdId) {
		
		return studentdao.getStudent(stdId);
	}

	public String addStudent(Student std) {
		int update = studentdao.addStudent(std);
		if (update == -1) {
			return "Duplicate entry, enter new empId";
		}
		return "New Student added into the database: " + std.getStdId() + ": " + std.getName();
	}
	
	public String deleteStudent(int stdId) {
		studentdao.deleteStudent(stdId);
		return "Student deleted from the database: " + stdId;
	}

	public String addAllStudents(List<Student> stds) {
//			daolayer.add
		return "All students added into the database";
	}
	
	public String updateStudent(Student std) {
		int update = studentdao.updateStudent(std);
		if (update == -1) {
			return "Student not found";
		}
		return "Student updated into the database: " + std.getStdId();
	}
}
