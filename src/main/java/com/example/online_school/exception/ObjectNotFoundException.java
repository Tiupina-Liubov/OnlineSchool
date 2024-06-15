package com.example.online_school.exception;

/**
 * Exception thrown when an attempt is made to access an object that does not exist.
 */
public class ObjectNotFoundException extends RuntimeException {

    /**
     * Constructs a new object not found exception with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the getMessage() method)
     */
    public ObjectNotFoundException(String message) {
        super(message);
    }
}
