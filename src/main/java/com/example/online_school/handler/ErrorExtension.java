package com.example.online_school.handler;

import lombok.Value;
import org.springframework.http.HttpStatus;

/**
 * Represents an error extension containing a message and an HTTP status code.
 */
@Value
public class ErrorExtension {

    /**
     * The error message.
     */
    String message;

    /**
     * The HTTP status code.
     */
    HttpStatus errorCode;

    /**
     * Constructs an ErrorExtension object with the specified message and HTTP status code.
     *
     * @param message   the error message
     * @param errorCode the HTTP status code
     */
    public ErrorExtension(String message, HttpStatus errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }
}
