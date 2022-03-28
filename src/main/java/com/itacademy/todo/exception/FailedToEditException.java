package com.itacademy.todo.exception;

public class FailedToEditException extends RuntimeException {
    public FailedToEditException(String message) {
        super(message);
    }
}
