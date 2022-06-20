package com.kodestack.demo.Exceptions;


import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    protected HttpStatus statusCode;
    protected String name;
    protected String message;
    protected String code;
}
