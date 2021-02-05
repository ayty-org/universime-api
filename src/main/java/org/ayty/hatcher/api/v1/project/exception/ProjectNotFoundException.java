package org.ayty.hatcher.api.v1.project.exception;

public class ProjectNotFoundException extends  RuntimeException {
    private static final long serialVersionUID = 1L;

    public ProjectNotFoundException(String msg) {
        super(msg);
    }

    public ProjectNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
