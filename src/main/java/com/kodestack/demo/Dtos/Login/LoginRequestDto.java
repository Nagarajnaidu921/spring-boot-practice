package com.kodestack.demo.Dtos.Login;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String email;
    private String password;
}
