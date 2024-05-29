package com.example.online_school.exception;

/**
 * Exception thrown when an attempt is made to access an object that does not exist.
 *
 * Исключение, возникающее при попытке получить доступ к объекту, который не существует.
 */
public class ObjectNotFoundException extends RuntimeException {

    /**
     * Constructs a new object not found exception with the specified detail message.
     *
     * Создает новое исключение, когда объект не найден с указанным детализированным сообщением.
     *
     * @param message the detail message (which is saved for later retrieval by the getMessage() method)
     *                детализированное сообщение (которое сохраняется для последующего извлечения методом getMessage())
     */
    public ObjectNotFoundException(String message) {
        super(message);
    }
}
