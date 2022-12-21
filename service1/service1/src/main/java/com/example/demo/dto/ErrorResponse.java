package com.example.demo.dto;


import com.example.demo.config.ExceptionAdvisor;
import com.example.demo.exception.ErrorType;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Entity for API error responses
 *
 * @see ExceptionAdvisor
 */
@Data
@AllArgsConstructor
public class ErrorResponse {
    /**
     * Type of returned error
     */
    private ErrorType errorType;


    /**
     * Description of exception
     */
    private String errorMessage;
}
