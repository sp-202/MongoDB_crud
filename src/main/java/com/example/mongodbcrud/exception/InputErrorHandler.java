package com.example.mongodbcrud.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class InputErrorHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handelInvalidUserInput(MethodArgumentNotValidException exception) {
        Map<String, String> notValidException = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error -> {
            notValidException.put(error.getField(), error.getDefaultMessage());
        });

        return notValidException;
    }
}
