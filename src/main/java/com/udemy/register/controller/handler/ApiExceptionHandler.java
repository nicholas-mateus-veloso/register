package com.udemy.register.controller.handler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handlerMethodArgumentNotValidException(
            MethodArgumentNotValidException exception,
            HttpServletRequest request) {
        var errros = new ArrayList<FieldMessage>();

        exception.getBindingResult().getFieldErrors()
                .forEach(
                        fieldError -> errros.add(new FieldMessage(fieldError.getField(), fieldError.getDefaultMessage()))
                );

        ErrorResponse error = new ErrorResponse();
        error.setTimestamp(System.currentTimeMillis());
        error.setStatus(HttpStatus.BAD_REQUEST);
        error.setMessage(error.getMessage());
        error.setPath(request.getRequestURI());
        error.setErrors(errros);

        return ResponseEntity.badRequest().body(error);
    }

}