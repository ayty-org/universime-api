package org.ayty.hatcher.api.v1.course.service;

import org.ayty.hatcher.api.v1.course.jpa.Course;
import org.ayty.hatcher.api.v1.course.jpa.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.ayty.hatcher.api.v1.course.builder.CourseBuilder.createCourseBuilder;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Tag("service")
@DisplayName("List courses")
class ListCourseServiceTest {

    @Mock
    private CourseRepository courseRepository;

    private ListCourseServiceImpl listCourseService;

    @BeforeEach
    void setUp(){
        this.listCourseService = new ListCourseServiceImpl(this.courseRepository);
    }

    @Test
    @DisplayName("Should show all courses pageable")
    void shouldShowAllCourses() throws ParseException {
        Pageable pageable = PageRequest.of(0, 2, Sort.by(Sort.Direction.fromString("ASC"), "id"));
        when(this.listCourseService.findAll(pageable)).thenReturn(
                new PageImpl<>(new ArrayList<>(Arrays.asList(
                        createCourseBuilder().name("Teste 1").description("Desc 1").build(),
                        createCourseBuilder().name("Teste 2").description("Desc 2").build(),
                        createCourseBuilder().name("Teste 3").description("Desc 3").build(),
                        createCourseBuilder().build())))
        );

        Page<Course> courseResult = this.listCourseService.findAll(pageable);

        assertAll(
                "rebels page",
                () -> assertThat(courseResult.getTotalElements(), is(4L)),
                () -> assertThat(courseResult.getNumber(), is(0)),
                () -> assertThat(courseResult.getTotalPages(), is(1)),
                () -> assertThat(courseResult.getContent().get(0).getName(), is("Teste 1")),
                () -> assertThat(courseResult.getContent().get(1).getName(), is("Teste 2")),
                () -> assertThat(courseResult.getContent().get(2).getName(), is("Teste 3")),
                () -> assertThat(courseResult.getContent().get(3).getName(), is("Sistemas de Informação")),
                () -> assertThat(courseResult.getContent().get(0).getDescription(), is("Desc 1")),
                () -> assertThat(courseResult.getContent().get(1).getDescription(), is("Desc 2")),
                () -> assertThat(courseResult.getContent().get(2).getDescription(), is("Desc 3")),
                () -> assertThat(courseResult.getContent().get(3).getDescription(), is("Descrição do curso"))
        );

    }
}
