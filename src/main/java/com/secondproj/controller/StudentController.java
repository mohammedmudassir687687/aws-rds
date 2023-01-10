package com.secondproj.controller;

//import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.secondproj.model.Employee;
import com.secondproj.model.Student;
import com.secondproj.service.StudentService;
import com.secondproj.service.impl.StudentServiceImpl;

	
@RestController
public class StudentController {
	
	@Autowired
	private StudentServiceImpl studentService;


	@GetMapping(value = "/")
	public String homePage() {	
		return "welcome to real world training second application";
	}
	
	@GetMapping("/students")
	public List<Student> createList() {
		
		return studentService.getAllStudents();
	}
	
	@GetMapping(path = { "/students/{id}" })
	public Student getEmp(@PathVariable("id") int id) {
		
		return studentService.getStudent(id);

	}
	
	@PostMapping(path = {"/students"})
	public String create(@Valid @RequestBody Student user) {
		
		return studentService.addStudent(user);

	}
	
	@PutMapping(path = {"/students"})
	public String update(@Valid @RequestBody Student user) {
		return studentService.updateStudent(user);
	}

	@DeleteMapping(path = { "/students/{id}" })
	public String delete(@PathVariable("id") int id) {
		
		return studentService.deleteStudent(id);
		
	}
	



}


