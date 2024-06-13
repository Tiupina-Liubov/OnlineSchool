package com.example.online_school.exception;

/**
 * Exception thrown when data provided is invalid.
 */
public class InvalidDataException extends RuntimeException {

    /**
     * Constructs a new invalid data exception with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the getMessage() method)
     */
    public InvalidDataException(String message) {
        super(message);
    }
}
