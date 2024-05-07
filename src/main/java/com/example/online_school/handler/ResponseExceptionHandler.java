package com.example.online_school.handler;

import com.example.online_school.exception.IdNotFoundException;
import com.example.online_school.exception.ObjectAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ObjectAlreadyExistsException.class)
    @ResponseStatus(CONFLICT)
    public ResponseEntity<ErrorExtension> handleObjectAlreadyExistsException(ObjectAlreadyExistsException e) {
        return new ResponseEntity<>(new ErrorExtension(
                e.getMessage(), CONFLICT),
                CONFLICT);
    }


    @ExceptionHandler(IdNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ResponseEntity<ErrorExtension> handleIdNotFoundException(Exception e) {
        return new ResponseEntity<>(new ErrorExtension(
                e.getMessage(), HttpStatus.NOT_FOUND),
                HttpStatus.NOT_FOUND);
    }
}
