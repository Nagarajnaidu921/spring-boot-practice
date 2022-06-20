package com.kodestack.demo.Exceptions;


import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ValidationExceptionResponse extends ErrorResponse {
    private List<String> messages;

    public ValidationExceptionResponse(HttpStatus statusCode, String name, String message, String code,
            List<String> messages) {
                super(statusCode, name, message, code);
                this.messages = messages;
    }

}
