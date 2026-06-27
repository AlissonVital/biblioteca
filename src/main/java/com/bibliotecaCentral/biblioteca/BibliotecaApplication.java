package com.bibliotecaCentral.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EntityScan(basePackages = "com.bibliotecaCentral")
@ComponentScan(basePackages = "com.bibliotecaCentral")
@EnableJpaRepositories(basePackages = "com.bibliotecaCentral")
public class BibliotecaApplication {

	public static void main(String[] args) {

		SpringApplication.run(BibliotecaApplication.class, args);
	}
}
