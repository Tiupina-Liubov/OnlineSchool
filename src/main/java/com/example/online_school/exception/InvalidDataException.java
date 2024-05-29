package com.example.online_school.exception;

/**
 * Exception thrown when data provided is invalid.
 *
 * Исключение, возникающее, когда предоставленные данные недопустимы.
 */
public class InvalidDataException extends RuntimeException {

    /**
     * Constructs a new invalid data exception with the specified detail message.
     *
     * Создает новое исключение с указанным детализированным сообщением.
     *
     * @param message the detail message (which is saved for later retrieval by the getMessage() method)
     *                детализированное сообщение (которое сохраняется для последующего извлечения методом getMessage())
     */
    public InvalidDataException(String message) {
        super(message);
    }
}
