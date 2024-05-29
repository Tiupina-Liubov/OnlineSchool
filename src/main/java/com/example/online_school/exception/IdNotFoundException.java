package com.example.online_school.exception;

/**
 * Exception thrown when an ID is not found.
 *
 * Исключение, возникающее, когда идентификатор не найден.
 */
public class IdNotFoundException extends RuntimeException {

    /**
     * Constructs a new ID not found exception with the specified detail message.
     *
     * Создает новое исключение с указанным детализированным сообщением.
     *
     * @param message the detail message (which is saved for later retrieval by the getMessage() method)
     *                детализированное сообщение (которое сохраняется для последующего извлечения методом getMessage())
     */
    public IdNotFoundException(String message) {
        super(message);
    }
}
