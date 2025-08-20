package org.envycorp.model.Exceptions;

public class SceneLoadingException extends RuntimeException {
    public SceneLoadingException(String message) {
        super(message);
    }

    public SceneLoadingException(Throwable cause) {
        super(cause);
    }
}
