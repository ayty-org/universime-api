package org.ayty.hatcher.api.v1.course.service;

import org.ayty.hatcher.api.v1.course.jpa.Course;

@FunctionalInterface
public interface GetCourseService {
    Course get (Long id);
}
