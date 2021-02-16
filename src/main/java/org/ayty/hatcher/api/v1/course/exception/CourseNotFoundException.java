package org.ayty.hatcher.api.v1.course.exception;

import org.ayty.hatcher.api.v1.course.dto.CourseDTO;
import org.ayty.hatcher.api.v1.course.jpa.Course;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CourseNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public CourseNotFoundException(String message, Throwable cause) {
        super(message,cause);
    }
    public CourseNotFoundException(String message) {
        super(message);
    }
    public CourseNotFoundException (){
        super("Course not found!");
    }
}
