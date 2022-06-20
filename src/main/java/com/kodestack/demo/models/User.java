package com.kodestack.demo.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity()
@Data
@Table(name = "users")
public class User implements Serializable  {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 200)
    private String name;

    @Column(unique = true)
    @Email(message = "'${validatedValue}' is not a valid email")
    @NotNull(message = "Email should not be null")
    private String email;

    @Column()
    @NotNull(message = "Password should not be null")
    @Min(
        value = 8,
        message = "Password lengh should be more than 8 charecters"
    )
    private String password;

}
