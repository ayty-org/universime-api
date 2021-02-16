package org.ayty.hatcher.api.v1.course.service;

import org.ayty.hatcher.api.v1.course.exception.CourseNotFoundException;
import org.ayty.hatcher.api.v1.course.jpa.Course;
import org.ayty.hatcher.api.v1.course.jpa.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.ayty.hatcher.api.v1.course.builder.CourseBuilder.createCourseBuilder;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Tag("service")
@DisplayName("Get list of courses")
class GetCourseServiceTest {

    @Mock
    private CourseRepository courseRepository;

    private GetCourseServiceImpl getCourseService;

    @BeforeEach
    public void setUp(){
        this.getCourseService = new GetCourseServiceImpl(courseRepository);
    }

    @Test
    @DisplayName("Should find course by ID")
    void shouldReturnCourses() {
        when(courseRepository.findById(anyLong())).thenReturn(Optional.of(createCourseBuilder().name("Sistemas").build()));
        Course courseResult = this.getCourseService.get(1L);
        assertAll("course",
                ()->assertThat(courseResult.getName(), is("Sistemas")),
                ()->assertThat(courseResult.getDescription(), is("Descrição do curso"))
        );
    }

    @Test
    @DisplayName("Should throw a exception when course not found")
    void shouldThrowCourseNotFoundException (){
        when(courseRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(CourseNotFoundException.class, ()->this.getCourseService.get(1L));
    }
}
