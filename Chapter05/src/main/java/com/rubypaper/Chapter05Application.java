package com.rubypaper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Chapter05Application {

	public static void main(String[] args) {
		SpringApplication springApplication =  new SpringApplication(Chapter05Application.class);
		
		springApplication.setWebApplicationType(WebApplicationType.NONE);
		springApplication.run(args);
	}

}
