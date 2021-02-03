package org.ayty.hatcher.api;

import org.ayty.hatcher.api.v1.competence.dto.Course;
import org.ayty.hatcher.api.v1.competence.jpa.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class HatcherApiApplication{




	public static void main(String[] args) {
		SpringApplication.run(HatcherApiApplication.class, args);
	}

	/*@Override
	public void run(String... args) throws Exception {
		Course c1 = new Course(null, "Sistemas", "Description");
		courseRepository.save(c1);

	}*/
}
