package com.secondproj.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.secondproj.model.Employee;

@Controller
public class MainController {
	@RequestMapping("/employeesdata")
	public String getEmployeesData(Model model) {
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<Employee[]> response = restTemplate.getForEntity("http://localhost:8080/employees", Employee[].class);
		Employee[] employeesdata = response.getBody();
		model.addAttribute("employeesdata", employeesdata);
		return "index";
	}
}
