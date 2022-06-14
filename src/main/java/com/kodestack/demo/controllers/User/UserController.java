package com.kodestack.demo.controllers.User;

import java.net.URI;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodestack.demo.models.Users;
import com.kodestack.demo.repo.UserRepository;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserRepository userRepo;

    @GetMapping
    public ResponseEntity<List<Users>> findAllUsers() {

        List<Users> users = userRepo.findAll();
        System.out.println(users.get(0).getClass());
        // Implement
        return ResponseEntity.ok().body(users);
    }

    @PostMapping
    public Users createUSer(@RequestBody Users users) {
        
        Users persistedUser = userRepo.save(users);

        return persistedUser;
    }
}
