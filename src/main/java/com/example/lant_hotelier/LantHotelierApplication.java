package com.example.lant_hotelier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.lant_hotelier.repositories")
@EntityScan(basePackages = "com.example.lant_hotelier.entities")
public class LantHotelierApplication {
	public static void main(String[] args) {
		SpringApplication.run(LantHotelierApplication.class, args);
	}
}