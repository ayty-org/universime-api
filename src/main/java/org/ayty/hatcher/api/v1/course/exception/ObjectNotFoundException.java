package org.ayty.hatcher.api.v1.course.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ObjectNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException (String message, Throwable cause) {
        super(message,cause);
    }
    public ObjectNotFoundException (String message) {
        super(message);
    }
}
