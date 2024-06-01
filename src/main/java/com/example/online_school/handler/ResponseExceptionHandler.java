package com.example.online_school.handler;

import com.example.online_school.exception.IdNotFoundException;
import com.example.online_school.exception.InvalidIdException;
import com.example.online_school.exception.ObjectAlreadyExistsException;
import com.example.online_school.exception.ObjectNotFoundException;
import com.example.online_school.exception.errorMessage.ErrorMessage;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

/**
 * Global exception handler for handling various types of exceptions across the application.
 *
 * Глобальный обработчик исключений для обработки различных типов исключений в приложении.
 */
@RestControllerAdvice
public class ResponseExceptionHandler {

    /**
     * Handles the exception when an object already exists.
     *
     * Обрабатывает исключение, когда объект уже существует.
     *
     * @param e The ObjectAlreadyExistsException instance.
     * @return ResponseEntity containing the error message and status code.
     */
    @ExceptionHandler(ObjectAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<ErrorExtension> handleObjectAlreadyExistsException(ObjectAlreadyExistsException e) {
        return new ResponseEntity<>(new ErrorExtension(e.getMessage(), HttpStatus.CONFLICT), HttpStatus.CONFLICT);
    }

    /**
     * Handles the exception when the specified ID is not found.
     *
     * Обрабатывает исключение, когда указанный идентификатор не найден.
     *
     * @param e The IdNotFoundException instance.
     * @return ResponseEntity containing the error message and status code.
     */
    @ExceptionHandler(IdNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorExtension> handleIdNotFoundException(IdNotFoundException e) {
        return new ResponseEntity<>(new ErrorExtension(e.getMessage(), HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    /**
     * Handles the exception when the specified object is not found.
     *
     * Обрабатывает исключение, когда указанный объект не найден.
     *
     * @param e The ObjectNotFoundException instance.
     * @return ResponseEntity containing the error message and status code.
     */
    @ExceptionHandler(ObjectNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorExtension> handleObjectNotFoundException(ObjectNotFoundException e) {
        return new ResponseEntity<>(new ErrorExtension(e.getMessage(), HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);
    }

    /**
     * Handles the exception when an invalid ID is encountered.
     *
     * Обрабатывает исключение, когда встречается недопустимый идентификатор.
     *
     * @param ex The InvalidIdException instance.
     * @return ResponseEntity containing the error message and status code.
     */
    @ExceptionHandler(InvalidIdException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorExtension> handleInvalidIdException(InvalidIdException ex) {
        return new ResponseEntity<>(new ErrorExtension(ex.getMessage(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles the exception when a SQL integrity constraint violation occurs.
     *
     * Обрабатывает исключение, когда возникает нарушение целостности SQL-констрейнтов.
     *
     * @param e The SQLIntegrityConstraintViolationException instance.
     * @return ResponseEntity containing the error message and status code.
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<ErrorExtension> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e) {
        return new ResponseEntity<>(new ErrorExtension(e.getMessage(), HttpStatus.CONFLICT), HttpStatus.CONFLICT);
    }

    /**
     * Handles the exception when a handler method validation fails.
     *
     * Обрабатывает исключение, когда валидация метода обработчика не удалась.
     *
     * @param ex The HandlerMethodValidationException instance.
     * @return ResponseEntity containing the error message and status code.
     */
    @ExceptionHandler(HandlerMethodValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorExtension> handleHandlerMethodValidationException(HandlerMethodValidationException ex) {
        String customMessage = ErrorMessage.INVALID_DATA;
        return new ResponseEntity<>(new ErrorExtension(customMessage, HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles the exception when JSON parsing fails.
     *
     * Обрабатывает исключение, когда не удается распарсить JSON.
     *
     * @param ex The HttpMessageNotReadableException instance.
     * @return ResponseEntity containing the error message and status code.
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorExtension> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        String customMessage = ErrorMessage.INVALID_DATA;
        return new ResponseEntity<>(new ErrorExtension(customMessage, HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles the exception when a constraint violation occurs.
     *
     * Обрабатывает исключение, когда возникает нарушение ограничений.
     *
     * @param ex The ConstraintViolationException instance.
     * @return ResponseEntity containing the error message and status code.
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorExtension> handleConstraintViolationException(ConstraintViolationException ex) {
        String customMessage = ErrorMessage.INVALID_UUID;
        return new ResponseEntity<>(new ErrorExtension(customMessage, HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles the exception when method argument validation fails.
     *
     * Обрабатывает исключение, когда не удается провести валидацию аргументов метода.
     *
     * @param ex The MethodArgumentNotValidException instance.
     * @return ResponseEntity containing the error message and status code.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorExtension> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), getErrorMessageForField(error.getField())));
        return new ResponseEntity<>(new ErrorExtension(errors.toString(), HttpStatus.BAD_REQUEST), HttpStatus.BAD_REQUEST);
    }

    /**
     * Gets the error message for the specified field.
     *
     * Получает сообщение об ошибке для указанного поля.
     *
     * @param fieldName The name of the field.
     * @return The error message for the field.
     */
    private String getErrorMessageForField(String fieldName) {
        return switch (fieldName) {
            case "id" -> ErrorMessage.INVALID_UUID;
            case "email" -> ErrorMessage.INVALID_EMAIL;
            case "password" -> ErrorMessage.INVALID_PASSWORD;
            case "phoneNumber" -> ErrorMessage.INVALID_PHONE_NUMBER;
            case "lastName" -> ErrorMessage.INVALID_LASTNAME;
            case "firstName" -> ErrorMessage.INVALID_FIRST_NAME;
            default -> ErrorMessage.INVALID_USERNAME;
        };
    }
}
