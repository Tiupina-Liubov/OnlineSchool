package com.example.online_school.handler;

import com.example.online_school.exception.IdNotFoundException;
import com.example.online_school.exception.InvalidIdException;
import com.example.online_school.exception.ObjectAlreadyExistsException;
import com.example.online_school.exception.ObjectNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.*;

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
    public ResponseEntity<ErrorExtension> handleIdNotFoundException(IdNotFoundException e) {
        return new ResponseEntity<>(new ErrorExtension(
                e.getMessage(), NOT_FOUND),
                NOT_FOUND);
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ResponseEntity<ErrorExtension> handleObjectNotFoundException(ObjectNotFoundException e) {
        return new ResponseEntity<>(new ErrorExtension(
                e.getMessage(), NOT_FOUND),
                NOT_FOUND);
    }

    @ExceptionHandler(InvalidIdException.class)
    @ResponseStatus(BAD_REQUEST)
    public ResponseEntity<ErrorExtension> handleInvalidIdException(InvalidIdException e) {
        return new ResponseEntity<>(new ErrorExtension(
                e.getMessage(), BAD_REQUEST),
                BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<Object> handleConstraintViolationException(RuntimeException ex, WebRequest request) {
        String errorMessage = ex.getMessage();
        HttpStatus errorCode = BAD_REQUEST;
        ErrorExtension errorExtension = new ErrorExtension(errorMessage, errorCode);
        return new ResponseEntity<>(errorExtension, errorCode);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatusCode status,
                                                                  WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        ErrorExtension errorExtension = new ErrorExtension(errors.toString(), BAD_REQUEST);
        return new ResponseEntity<>(errorExtension, BAD_REQUEST);
    }


}

