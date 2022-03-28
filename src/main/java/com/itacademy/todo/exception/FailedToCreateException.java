package com.itacademy.todo.exception;

public class FailedToCreateException extends RuntimeException {
    public FailedToCreateException(String message) {
        super(message);
    }
}
