package com.kodestack.demo.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@EnableAutoConfiguration
@ToString(includeFieldNames = true)
@Table(name = "users")
public class Users implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 200)
    private String name;

    @Column(length = 200, unique = true)
    private String email;
}
