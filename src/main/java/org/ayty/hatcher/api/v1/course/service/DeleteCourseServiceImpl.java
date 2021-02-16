package org.ayty.hatcher.api.v1.course.service;

import lombok.RequiredArgsConstructor;
import org.ayty.hatcher.api.v1.course.exception.CourseNotDeleteException;
import org.ayty.hatcher.api.v1.course.jpa.CourseRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public final class DeleteCourseServiceImpl implements DeleteCourseService{

    private final CourseRepository courseRepository;

    @Override
    public void delete (Long id) {
        if(!this.courseRepository.existsById(id)) throw new CourseNotDeleteException();
        else this.courseRepository.deleteById(id);
    }
}
