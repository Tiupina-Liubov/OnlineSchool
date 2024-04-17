package com.example.online_school.exception;

public class IdNotFoundException extends RuntimeException {
    public IdNotFoundException(String message) {
        super("\u001B[31m" + message + "\u001B[0m");
    }
}
