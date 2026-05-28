package com.orbitalert.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class OrbitalertApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrbitalertApiApplication.class, args);
	}

}
