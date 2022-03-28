package com.itacademy.todo.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<Object> userNotFoundExceptionHandler(RuntimeException ex, WebRequest request) {
        return handleException(ex, request, HttpStatus.NOT_FOUND, "User not found!");
    }

    private ResponseEntity<Object> handleException(RuntimeException ex, WebRequest request, HttpStatus status, String message) {
        return handleExceptionInternal(ex, new ErrorResponse(message, status.value(), getUri(request)), new HttpHeaders(), status, request);
    }

    private String getUri(WebRequest request) {
        return ((ServletWebRequest)request).getRequest().getRequestURI();
    }
}
