package org.ayty.hatcher.api.v1.competence.service;

import org.assertj.core.api.Assertions;
import org.ayty.hatcher.api.v1.competence.dto.Course;
import org.ayty.hatcher.api.v1.competence.jpa.CourseRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.GeneratedValue;
import javax.validation.ConstraintViolationException;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void createShouldPersistData(){
        Course course = new Course(null, "name", "desc");
        this.courseRepository.save(course);
        assertThat(course.getId()).isNotNull();
        assertThat(course.getName()).isEqualTo("name");
        assertThat(course.getDescription()).isEqualTo("desc");

    }

    @Test
    public void deleteShouldRemoveData() {
        Course course = new Course(null, "name", "desc");
        this.courseRepository.save(course);
        this.courseRepository.delete(course);
        assertThat(courseRepository.findById(course.getId())).isEmpty();

    }

    @Test
    public void updateShouldChangeAndPersistData(){
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

    @Test
    public void nameNullShouldThrownConstraintViolationException(){
        thrown.expect(ConstraintViolationException.class);
        thrown.expectMessage("Não pode ser deixado vazio");
        this.courseRepository.save(new Course());
    }

}
