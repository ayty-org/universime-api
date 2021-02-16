package org.ayty.hatcher.api.v1.course.service;

import org.ayty.hatcher.api.v1.course.jpa.Course;
import org.ayty.hatcher.api.v1.course.jpa.CourseRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@ExtendWith(MockitoExtension.class)
@Tag("service")
@DisplayName("Update course")
class UpdateCourseServiceTest {

    @Mock
    private CourseRepository courseRepository;

    private UpdateCourseServiceImpl updateCourseService;
    private CreateCourseServiceImpl createCourseService;
    private GetCourseServiceImpl getCourseService;

    @Test
    void setUp(){
        this.updateCourseService = new UpdateCourseServiceImpl(this.courseRepository);
    }

    @Test
    @DisplayName("Should update course by ID")
    void shouldUpdateCourse() {
        String name = "Update";
        String desc = "UpDesc";
        Course course = new Course(1L,name,desc);
        course.setName("Updating");

        courseRepository.save(course);

        assertAll("courses",
                ()->assertThat(course.getName().equals("Updating")),
                ()->assertThat(course.getDescription().equals("UpDesc"))
        );

    }
}

