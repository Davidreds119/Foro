package com.aluracursos.foro;

import com.aluracursos.foro.models.Argumentos;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
@SpringBootApplication
public class ForoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ForoApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

	}
}

