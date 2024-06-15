package com.example.online_school.exception;

/**
 * Exception thrown when an invalid ID is encountered.
 */
public class InvalidIdException extends RuntimeException {

    /**
     * Constructs a new invalid ID exception with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the getMessage() method)
     */
    public InvalidIdException(String message) {
        super(message);
    }
}
