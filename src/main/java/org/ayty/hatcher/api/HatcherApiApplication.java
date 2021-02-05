package org.ayty.hatcher.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
