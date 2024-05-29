package com.example.online_school.exception;

/**
 * Exception thrown when an attempt is made to create an object that already exists.
 *
 * Исключение, возникающее, когда попытка создать объект, который уже существует.
 */
public class ObjectAlreadyExistsException extends RuntimeException {

    /**
     * Constructs a new object already exists exception with the specified detail message.
     *
     * Создает новое исключение, когда объект уже существует с указанным детализированным сообщением.
     *
     * @param message the detail message (which is saved for later retrieval by the getMessage() method)
     *                детализированное сообщение (которое сохраняется для последующего извлечения методом getMessage())
     */
    public ObjectAlreadyExistsException(String message) {
        super(message);
    }
}
