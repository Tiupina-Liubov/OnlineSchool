package com.example.online_school.exception;

/**
 * Exception thrown when an invalid ID is encountered.
 *
 * Исключение, возникающее при обнаружении недопустимого идентификатора.
 */
public class InvalidIdException extends RuntimeException {

    /**
     * Constructs a new invalid ID exception with the specified detail message.
     *
     * Создает новое исключение с указанным детализированным сообщением.
     *
     * @param message the detail message (which is saved for later retrieval by the getMessage() method)
     *                детализированное сообщение (которое сохраняется для последующего извлечения методом getMessage())
     */
    public InvalidIdException(String message) {
        super(message);
    }
}
