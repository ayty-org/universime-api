package org.ayty.hatcher.api.v1.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProjectNotFoundException extends  RuntimeException {
    private static final long serialVersionUID = 1L;

    public ProjectNotFoundException(String msg) {
        super(msg);
    }
    public ProjectNotFoundException() {
        super();
    }

    public ProjectNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
