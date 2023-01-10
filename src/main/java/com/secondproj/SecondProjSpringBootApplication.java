package com.secondproj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.secondproj.dao.StudentDAO;

@SpringBootApplication
public class SecondProjSpringBootApplication implements CommandLineRunner {
	@Autowired
	private StudentDAO studentdao;
	
	public static void main(String[] args) {
		SpringApplication.run(SecondProjSpringBootApplication.class, args);
	}

	public void run(String... args) throws Exception {
		System.out.println(this.studentdao.createTable());
	}
}
