package com.example.online_school.exception;

/**
 * Exception thrown when an attempt is made to create an object that already exists.
 */
public class ObjectAlreadyExistsException extends RuntimeException {

    /**
     * Constructs a new object already exists exception with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the getMessage() method)
     */
    public ObjectAlreadyExistsException(String message) {
        super(message);
    }
}
