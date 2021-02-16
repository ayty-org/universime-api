package org.ayty.hatcher.api.v1.course.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class CourseNotDeleteException extends RuntimeException{

    public CourseNotDeleteException (){
        super("Course not found!");
    }
}
