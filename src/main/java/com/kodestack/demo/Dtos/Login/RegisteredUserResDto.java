package com.kodestack.demo.Dtos.Login;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisteredUserResDto {
    private Long id;
    private String name;
    private String email;
}
