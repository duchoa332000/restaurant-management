package com.example.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ApplicationExceptionsNotFound.class)
    public ResponseEntity<Object> applicationNotFoundResponse(Exception ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), null);
        return handleExceptionInternal(ex, errorResponse, null, HttpStatus.NOT_FOUND, request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldError = result.getFieldErrors();
        List<String> errors = new ArrayList<>();
        for (FieldError error : fieldError) {
            errors.add(error.getDefaultMessage());
        }
        ErrorResponse errorResponse = new ErrorResponse("Bad request", errors);
        return handleExceptionInternal(ex, errorResponse, headers, status, request);
    }

}
