package com.kodestack.demo.controllers.Auth;

import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodestack.demo.Dtos.Login.LoginRequestDto;
import com.kodestack.demo.Services.User.UserService;
import com.kodestack.demo.models.User;
import com.kodestack.demo.repo.UserRepository;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public User login(@RequestBody LoginRequestDto loginCreds) {
        String plainPassword = loginCreds.getPassword();
        String email = loginCreds.getEmail();
        User user = userRepository.findOneByEmail(email);
        if (user == null) {
            System.out.println("test");
            // throw error
            return user;
        }

        Boolean b = userService.passwordEncoder().matches(plainPassword, user.getPassword());
        // generate jwt
        System.out.println(b);
        return user;
    }

}
