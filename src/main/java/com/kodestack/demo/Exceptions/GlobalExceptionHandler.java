package com.kodestack.demo.Exceptions;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public @ResponseBody ValidationExceptionResponse handleException(MethodArgumentNotValidException ex) {
        List<String> messages = new ArrayList<String>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String message = error.getDefaultMessage();
            messages.add(message);
        });

        return new ValidationExceptionResponse(HttpStatus.BAD_REQUEST, "Validation error", "Validation failed", "2001", messages);
    }
}
