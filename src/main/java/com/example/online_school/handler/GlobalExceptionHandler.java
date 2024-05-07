package com.example.online_school.handler;

import com.example.online_school.exception.IdNotFoundException;
import com.example.online_school.exception.ObjectAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ObjectAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleObjectAlreadyExistsException(ObjectAlreadyExistsException e) {
        return e.getMessage();  // Возвращаем сообщение об ошибке клиенту
    }

    @ExceptionHandler(IdNotFoundException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleIdNotFoundException(IdNotFoundException e) {
        return e.getMessage();  // Возвращаем сообщение об ошибке клиенту
    }
}
