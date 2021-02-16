package org.ayty.hatcher.api.v1.course.service;

import org.ayty.hatcher.api.v1.course.exception.CourseNotDeleteException;
import org.ayty.hatcher.api.v1.course.jpa.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@Tag("service")
@DisplayName("Delete course service")
class DeleteCourseServiceTest {

    @Mock
    private CourseRepository courseRepository;

    private DeleteCourseServiceImpl deleteCourseService;

    @BeforeEach
    public void setUp(){
        this.deleteCourseService = new DeleteCourseServiceImpl(this.courseRepository);
    }

    @Test
    @DisplayName("Should find delete course by ID")
    void shoulDeleteCourse (){
        when(courseRepository.existsById(1L)).thenReturn(true);
        deleteCourseService.delete(1L);
        verify(courseRepository).existsById(1L);
    }
    @Test
    @DisplayName("Should throws a exception when try to delete when not found")
    void shouldThrowsNotDeletedException(){
        lenient().when(courseRepository.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(CourseNotDeleteException.class, ()->this.deleteCourseService.delete(1L));
    }

}
