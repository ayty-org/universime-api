package org.ayty.hatcher.api;

import org.ayty.hatcher.api.v1.project.model.Project;
import org.ayty.hatcher.api.v1.project.jpa.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class HatcherApiApplication implements CommandLineRunner {

	@Autowired
	private ProjectRepository projectRepository;

	public static void main(String[] args) {
		SpringApplication.run(HatcherApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		LocalDate startDate = LocalDate.parse("2021-02-20");
		LocalDate endDate = LocalDate.parse("2021-10-20");

		Project p1 = new Project(null, "Projeto Spring Boot", "Projeto de desenvolvimento de API's utilizando Spring Boot", "/springboot.png", startDate, endDate);
		Project p2 = new Project(null, "Projeto Angular-Ionic", "Projeto de desenvolvimento de aplicações com Angular/Ionic", "/angular_ionic.png", startDate, endDate);

		projectRepository.saveAll(Arrays.asList(p1, p2));
	}
}
