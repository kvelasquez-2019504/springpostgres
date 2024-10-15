package com.kenneth.springpostgres.controller;

import com.kenneth.springpostgres.dto.UserDto;
import com.kenneth.springpostgres.entity.User;
import com.kenneth.springpostgres.exceptions.UserNotFoundException;
import com.kenneth.springpostgres.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/")
    public User createUser(@RequestBody UserDto userDto){
        User user = new User(userDto);//Creo un objeto user a partir de Dto, que maneja los datos
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent())
            return optionalUser.get();
        else throw new UserNotFoundException();
    }
}
