package com.testing.projectspring;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjectSpringApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProjectSpringApplication.class, args);

	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
