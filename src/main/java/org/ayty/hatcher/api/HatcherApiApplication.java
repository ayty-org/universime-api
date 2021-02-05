package org.ayty.hatcher.api;

import org.ayty.hatcher.api.v1.project.model.Project;
import org.ayty.hatcher.api.v1.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
public class HatcherApiApplication implements CommandLineRunner {

	@Autowired
	private ProjectRepository projectRepository;

	public static void main(String[] args) {
		SpringApplication.run(HatcherApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

		Project p1 = new Project(null, "Projeto Spring Boot", "Projeto de desenvolvimento de API's utilizando Spring Boot", "/springboot.png", sdf.parse("2021/01/04"), sdf.parse("2021/05/04"));
		Project p2 = new Project(null, "Projeto Angular-Ionic", "Projeto de desenvolvimento de aplicações com Angular/Ionic", "/angular_ionic.png", sdf.parse("2021/03/04"), sdf.parse("2021/12/04"));

		projectRepository.saveAll(Arrays.asList(p1, p2));
	}
}
