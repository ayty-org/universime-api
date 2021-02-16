package org.ayty.hatcher.api.v1.course.service;

import lombok.RequiredArgsConstructor;
import org.ayty.hatcher.api.v1.course.jpa.Course;
import org.ayty.hatcher.api.v1.course.jpa.CourseRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateCourseServiceImpl implements CreateCourseService {

    private final CourseRepository courseRepository;

    @Override
    public void create(Course course) {
        courseRepository.save(course);
    }
}
