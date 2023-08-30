package com.udemy.register.controller.handler;

import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.util.List;

@Builder
public class ErrorResponse {
    private Long timestamp;
    private HttpStatus status;
    private String message;
    private String path;
    private List<FieldMessage> errors;

    public ErrorResponse(Long timestamp, HttpStatus status, String message, String path, List<FieldMessage> errors) {
        this.timestamp = timestamp;
        this.status = status;
        this.message = message;
        this.path = path;
        this.errors = errors;
    }

    public ErrorResponse() {
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void setErrors(List<FieldMessage> errors) {
        this.errors = errors;
    }
}
