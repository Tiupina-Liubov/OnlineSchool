package com.example.online_school.handler;

import com.example.online_school.exception.IdNotFoundException;
import com.example.online_school.exception.InvalidIdException;
import com.example.online_school.exception.ObjectAlreadyExistsException;
import com.example.online_school.exception.ObjectNotFoundException;
import io.micrometer.core.instrument.config.validate.Validated;
import jakarta.validation.ConstraintViolationException;
import org.springframework.context.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

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
                e.getMessage(), HttpStatus.NOT_FOUND),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ResponseEntity<ErrorExtension> handleObjectNotFoundException(ObjectNotFoundException e) {
        return new ResponseEntity<>(new ErrorExtension(
                e.getMessage(), HttpStatus.NOT_FOUND),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidIdException.class)
    @ResponseStatus(BAD_REQUEST)
    public ResponseEntity<ErrorExtension> handleInvalidIdException(InvalidIdException e) {
        return new ResponseEntity<>(new ErrorExtension(
                e.getMessage(), HttpStatus.BAD_REQUEST),
                BAD_REQUEST);
    }


//    @Description(value = "Отлавливание невалидного UUID с помощью ConstraintViolationException.class")
//    @ExceptionHandler(value = { ConstraintViolationException.class, InvalidIdException.class })
//    protected ResponseEntity<Object> handleInvalidIdException(RuntimeException ex, WebRequest request) {
//        String errorMessage = ex.getMessage();
//        HttpStatus errorCode = HttpStatus.BAD_REQUEST;
//        if (ex instanceof ConstraintViolationException) {
//            errorMessage = ex.getMessage();
//        }
//        ErrorExtension errorExtension = new ErrorExtension(errorMessage, errorCode);
//        return new ResponseEntity<>(errorExtension, errorCode);
//    }


}
