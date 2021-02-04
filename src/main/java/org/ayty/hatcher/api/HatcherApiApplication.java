package org.ayty.hatcher.api;

import org.ayty.hatcher.api.v1.security.JwtAuthFilter;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HatcherApiApplication {


	public static void main(String[] args) {
		SpringApplication.run(HatcherApiApplication.class, args);
	}
	
	/*
	@Bean
	public FilterRegistrationBean<JwtAuthFilter> filtroJwt(){
		FilterRegistrationBean<JwtAuthFilter> filtroRB = new FilterRegistrationBean<JwtAuthFilter>();
		filtroRB.setFilter(new JwtAuthFilter());
		filtroRB.addUrlPatterns("hatcher/profile/registerUser","hatcher/profile/user/registerCourse","hatcher/profile/user/course/remove","hatche/profile/user/course/edit");
		return filtroRB;
		
	
	
	
	}
	*/

}
