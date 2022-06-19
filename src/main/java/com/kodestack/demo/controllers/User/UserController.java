package com.kodestack.demo.controllers.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kodestack.demo.Dtos.Login.RegisteredUserResDto;
import com.kodestack.demo.Services.User.UserService;
import com.kodestack.demo.models.User;
import com.kodestack.demo.repo.UserRepository;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserRepository userRepo;

    @Autowired
    UserService userService;

    @GetMapping
    public List<RegisteredUserResDto> findAllUsers() {
        ModelMapper modelMapper = new ModelMapper();
        List<User> users = userRepo.findAll();
        return users.stream().map(user -> modelMapper.map(user, RegisteredUserResDto.class)).collect(Collectors.toList());
    }

   

    @PostMapping
    public RegisteredUserResDto createUSer(@Valid @RequestBody User user) throws MethodArgumentNotValidException  {
        try {        
        String encodedPassword = userService.passwordEncoder().encode(user.getPassword());
        user.setPassword(encodedPassword);
        User persistedUser = userRepo.save(user);
        ModelMapper modelMapper = new ModelMapper();
        RegisteredUserResDto registeredUserResDto = modelMapper.map(persistedUser, RegisteredUserResDto.class);
        return registeredUserResDto;
        } catch (Exception e) {
            throw e;
        }
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    private Map<String, String> handleException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });

        return errors;
    }
}
