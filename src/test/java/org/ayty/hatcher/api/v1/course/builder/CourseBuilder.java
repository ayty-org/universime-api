package org.ayty.hatcher.api.v1.course.builder;


import org.ayty.hatcher.api.v1.course.jpa.Course;

public class CourseBuilder{

    public static Course.Builder createCourseBuilder() {

        return Course.builder().name("Sistemas de Informação").description("Descrição do curso");
    }


}
