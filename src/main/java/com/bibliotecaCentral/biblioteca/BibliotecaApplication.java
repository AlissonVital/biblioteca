package com.bibliotecaCentral.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.bibliotecaCentral")
@EntityScan(basePackages = "com.bibliotecaCentral")
@SpringBootApplication
public class BibliotecaApplication {

	public static void main(String[] args) {

		SpringApplication.run(BibliotecaApplication.class, args);
	}

}
