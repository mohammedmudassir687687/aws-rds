package com.newproj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.newproj.dao.EmployeeDAO;

@SpringBootApplication
public class NewProjSpringBootApplication implements CommandLineRunner {

	@Autowired
	private EmployeeDAO empdao;
	
	public static void main(String[] args) {
		SpringApplication.run(NewProjSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.empdao.createTable());
	}
}