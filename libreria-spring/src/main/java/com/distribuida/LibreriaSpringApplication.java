package com.distribuida;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.distribuida"})
public class LibreriaSpringApplication {
	public static void main(String[] args) {
		SpringApplication.run(LibreriaSpringApplication.class, args);
	}

}
