package com.system.care.health.HealthAndCareSystem;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HealthAndCareSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthAndCareSystemApplication.class, args);

	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
}