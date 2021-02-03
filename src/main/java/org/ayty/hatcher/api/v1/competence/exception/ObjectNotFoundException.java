package org.ayty.hatcher.api.v1.competence.exception;

public class ObjectNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException (String message, Throwable cause) {
        super(message,cause);
    }
    public ObjectNotFoundException (String message) {
        super(message);
    }
}
