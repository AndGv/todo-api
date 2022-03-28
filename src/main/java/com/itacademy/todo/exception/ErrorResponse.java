package com.itacademy.todo.exception;

public class ErrorResponse {
    private final String message;
    private final String path;
    private final int status;

    public ErrorResponse(String message, int status, String path) {
        this.message = message;
        this.status = status;
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public String getPath() {
        return path;
    }
}

