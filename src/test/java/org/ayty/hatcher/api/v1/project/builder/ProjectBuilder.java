package org.ayty.hatcher.api.v1.project.builder;

import org.apache.tomcat.jni.Local;
import org.ayty.hatcher.api.v1.project.model.Project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ProjectBuilder {

    public static Project createProject() throws ParseException {

        LocalDate startDate = LocalDate.parse("2021-02-20");
        LocalDate endDate = LocalDate.parse("2021-10-20");


        return Project.builder()
                .id(1)
                .name("Projeto Spring Boot")
                .description("Projeto para construção de uma API Rest utilizando Spring Boot.")
                .logo("images/logo.png")
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }
}
