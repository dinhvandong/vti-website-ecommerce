package com.vti.demorestfulapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class DemoRestfulApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoRestfulApiApplication.class, args);
	}
}
