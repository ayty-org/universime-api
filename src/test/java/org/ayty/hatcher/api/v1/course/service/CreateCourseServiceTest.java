package org.ayty.hatcher.api.v1.course.service;

import org.ayty.hatcher.api.v1.course.jpa.Course;
import org.ayty.hatcher.api.v1.course.jpa.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.ayty.hatcher.api.v1.course.builder.CourseBuilder.createCourseBuilder;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
@Tag("service")
@DisplayName("Create Course Service Test")
class CreateCourseServiceTest {

    @Mock
    private CourseRepository courseRepository;

    private CreateCourseServiceImpl createCourseService;

    @BeforeEach
    public void setUp(){
        this.createCourseService = new CreateCourseServiceImpl(this.courseRepository);
    }

    @Test
    @DisplayName("This test should save course")
    void shouldSaveCourse (){
        this.createCourseService.create(createCourseBuilder().build());
        ArgumentCaptor<Course> argumentCaptor = ArgumentCaptor.forClass(Course.class);
        verify(courseRepository).save(argumentCaptor.capture());
        Course courseResult = argumentCaptor.getValue();
        assertAll("course",
                ()->assertThat(courseResult.getName(), is("Sistemas de Informação")),
                ()->assertThat(courseResult.getDescription(), is("Descrição do curso"))
        );
    }
}
