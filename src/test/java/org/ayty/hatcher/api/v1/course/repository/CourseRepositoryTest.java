package org.ayty.hatcher.api.v1.course.repository;

import org.ayty.hatcher.api.v1.course.dto.Course;
import org.ayty.hatcher.api.v1.course.jpa.CourseRepository;
import org.ayty.hatcher.api.v1.course.service.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
@Tag("Repository")
@DisplayName("Persistence of Data")

class CourseRepositoryTest {

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    CourseService courseService;

    private static final String COURSE_NAME= "SI";
    private static final String DESCRIPTION = "Description";
    private static final Long ID = 1L;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);


    }
    @Test
    @DisplayName("Should save data")
    final void shouldPersist() {

        Course course = new Course(ID,COURSE_NAME,DESCRIPTION);

        when(courseService.create(course)).thenReturn(course);
        courseService.create(course);

        verify(courseRepository, times(1)).save(course);

        assertThat(course.getId()).isNotNull();
        assertThat(course.getName()).isNotEmpty();
        assertThat(course.getDescription()).isNotEmpty();
        assertThat(course.getId()).isEqualTo(1L);
        assertThat(course.getName()).isEqualTo("SI");
    }


    @Test
    @DisplayName("Should remove data")
    void deleteShouldRemoveData() {
        Course course = new Course(ID, COURSE_NAME, DESCRIPTION);

        when(courseService.create(course)).thenReturn(course);
        courseService.create(course);

        this.courseRepository.delete(course);
        assertThat(courseRepository.findById(course.getId())).isEmpty();

    }

    @Test
    @DisplayName("Should modify data")
    void updateShouldChangeAndPersistData(){
        Course course = new Course(ID, COURSE_NAME, DESCRIPTION);
        when(courseService.create(course)).thenReturn(course);
        courseService.create(course);
        course.setName("name2");
        course.setDescription("Desc2");
        this.courseRepository.save(course);
        this.courseRepository.findById(course.getId());
        assertThat(course.getId()).isNotNull();
        assertThat(course.getName()).isEqualTo("name2");
        assertThat(course.getDescription()).isEqualTo("Desc2");

    }


}
