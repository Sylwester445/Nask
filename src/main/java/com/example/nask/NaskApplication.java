package com.example.nask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class NaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(NaskApplication.class, args);
	}

}
