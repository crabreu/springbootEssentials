package com.example.springbootEssentials;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.springbootEssentials.model.Curso;
import com.example.springbootEssentials.model.CursoRepository;
import com.example.springbootEssentials.model.Estudante;
import com.example.springbootEssentials.model.EstudanteRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication(scanBasePackages = {"com.example"})
@Slf4j
public class SpringbootEssentialsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootEssentialsApplication.class, args);
	}

		@Bean
	public CommandLineRunner loadDatabase(CursoRepository repository , EstudanteRepository erepository) {
	log.info("Loading data...");
		if (repository.count() > 0 && erepository.count() > 0) {
			return (args) -> {
			log.info("Database is not empty");
		};   
	}
		return (args) -> {
			log.info("Criando Database Cursos");
			repository.save(new Curso(1l, "Curso 1", 6));
			repository.save(new Curso(2l, "Curso 2", 4));
			repository.save(new Curso(3l, "Curso 3", 20));
			erepository.save(new Estudante(1l, "Estudante 1", ""));
			erepository.save(new Estudante(2l, "Estudante 2", ""));
			erepository.save(new Estudante(3l, "Estudante 3", ""));
			};
		
	}

}
