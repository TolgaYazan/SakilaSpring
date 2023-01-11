package com.uniyaz.sakila;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.uniyaz")
@EnableJpaRepositories(basePackages = "com.uniyaz")
@EntityScan(basePackages = "com.uniyaz")
public class SakilaRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SakilaRestApplication.class, args);
	}

}