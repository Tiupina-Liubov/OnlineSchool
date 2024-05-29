package com.example.online_school.handler;

import lombok.Value;
import org.springframework.http.HttpStatus;

/**
 * Represents an error extension containing a message and an HTTP status code.
 *
 * Представляет расширение ошибки, содержащее сообщение и код состояния HTTP.
 */
@Value
public class ErrorExtension {

    /**
     * The error message.
     *
     * Сообщение об ошибке.
     */
    String message;

    /**
     * The HTTP status code.
     *
     * Код состояния HTTP.
     */
    HttpStatus errorCode;

    /**
     * Constructs an ErrorExtension object with the specified message and HTTP status code.
     *
     * Создает объект ErrorExtension с указанным сообщением и кодом состояния HTTP.
     *
     * @param message   the error message
     *                  сообщение об ошибке
     * @param errorCode the HTTP status code
     *                  код состояния HTTP
     */
    public ErrorExtension(String message, HttpStatus errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}
