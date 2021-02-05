package org.ayty.hatcher.api.v1.course.jpa;

import org.ayty.hatcher.api.v1.course.dto.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
