package org.ayty.hatcher.api.v1.course.service;

import lombok.RequiredArgsConstructor;
import org.ayty.hatcher.api.v1.course.exception.CourseNotFoundException;
import org.ayty.hatcher.api.v1.course.jpa.Course;
import org.ayty.hatcher.api.v1.course.jpa.CourseRepository;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class GetCourseServiceImpl implements GetCourseService{

    private final CourseRepository courseRepository;

    @Override
    public Course get(Long id) {
        return this.courseRepository.findById(id).orElseThrow(()-> new CourseNotFoundException("Course with ID: " + id + " not found!"));
    }

}
