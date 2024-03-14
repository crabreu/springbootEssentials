package com.example.springbootEssentials;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.springbootEssentials.model.Curso;
import com.example.springbootEssentials.model.CursoRepository;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication(scanBasePackages = {"com.example"})
@Slf4j
public class SpringbootEssentialsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootEssentialsApplication.class, args);
	}

		@Bean
	public CommandLineRunner loadDatabase(CursoRepository repository) {
	log.info("Loading data...");
		if (repository.count() > 0) {
			return (args) -> {
			log.info("Database is not empty");
		};   
	}
		return (args) -> {
			log.info("Criando Database");
			repository.save(new Curso(1l, "Curso 1", 6));
			repository.save(new Curso(2l, "Curso 2", 4));
			repository.save(new Curso(3l, "Curso 3", 20));
			};
	}
}
