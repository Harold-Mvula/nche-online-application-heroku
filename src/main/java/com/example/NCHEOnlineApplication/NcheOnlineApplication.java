package com.example.NCHEOnlineApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class NcheOnlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(NcheOnlineApplication.class, args);
	}
}
