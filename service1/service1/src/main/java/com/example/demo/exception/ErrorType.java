package com.example.demo.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ErrorType {
    WRONG_PRICE("Wrong price"),
    NO_STOCK_FOUND("No such stock"),
    VALIDATION_ERROR("Validation error");

    private String message;

    public String getMessage() {
        return message;
    }
}
