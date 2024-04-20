package com.example.online_school.exception;

public class ObjectAlreadyExistsException extends Throwable {
    public ObjectAlreadyExistsException(String message) {
        super("\u001B[31m" + message + "\u001B[0m");
    }
}
