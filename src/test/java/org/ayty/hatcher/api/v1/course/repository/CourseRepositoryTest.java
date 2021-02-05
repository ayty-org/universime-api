package org.ayty.hatcher.api.v1.course.repository;

import org.ayty.hatcher.api.v1.course.dto.Course;
import org.ayty.hatcher.api.v1.course.jpa.CourseRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@Tag("Repository")
@DisplayName("Persistence of Data")

@DataJpaTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    void createShouldPersistData(){
        Course course = new Course(null, "name", "desc");
        this.courseRepository.save(course);
        assertThat(course.getId()).isNotNull();
        assertThat(course.getName()).isEqualTo("name");
        assertThat(course.getDescription()).isEqualTo("desc");

    }

    @Test
    void deleteShouldRemoveData() {
        Course course = new Course(null, "name", "desc");
        this.courseRepository.save(course);
        this.courseRepository.delete(course);
        assertThat(courseRepository.findById(course.getId())).isEmpty();

    }

    @Test
    void updateShouldChangeAndPersistData(){
        Course course = new Course(null, "name", "desc");
        this.courseRepository.save(course);
        course.setName("name2");
        course.setDescription("Desc2");
        this.courseRepository.save(course);
        this.courseRepository.findById(course.getId());
        assertThat(course.getId()).isNotNull();
        assertThat(course.getName()).isEqualTo("name2");
        assertThat(course.getDescription()).isEqualTo("Desc2");

    }

}
