package org.ayty.hatcher.api.v1.project.builder;

import org.ayty.hatcher.api.v1.project.model.Project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProjectBuilder {

    public static Project createProject() throws ParseException {

        Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse("2020-02-20");
        Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse("2020-05-20");

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
