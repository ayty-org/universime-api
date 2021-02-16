package org.ayty.hatcher.api.v1.course.service;

import org.ayty.hatcher.api.v1.course.jpa.Course;
import org.ayty.hatcher.api.v1.course.jpa.CourseRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.ayty.hatcher.api.v1.course.builder.CourseBuilder.createCourseBuilder;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Tag("service")
@DisplayName("Update course")
class UpdateCourseServiceTest {

    @Mock
    private CourseRepository courseRepository;

    private UpdateCourseServiceImpl updateCourseService;

    @Test
    void setUp(){
        this.updateCourseService = new UpdateCourseServiceImpl(this.courseRepository);
    }

    @Test
    @DisplayName("Should uptade course by ID")
    void shouldUpdateRebelLocation() {
        when(this.courseRepository.findById(1L)).thenReturn(Optional.of(createCourseBuilder().build()));

        this.updateCourseService.update(1L, new Course(1L, "updated", "updated"));

        ArgumentCaptor<Course> argumentCaptor = ArgumentCaptor.forClass(Course.class);
        verify(courseRepository).save(argumentCaptor.capture());

        Course courseResult = argumentCaptor.getValue();

        assertAll("rebel",
                () -> assertThat(courseResult.getId(), is(1L)),
                () -> assertThat(courseResult.getName(), is("updated")),
                () -> assertThat(courseResult.getDescription(), is("updated"))
        );
    }
}

