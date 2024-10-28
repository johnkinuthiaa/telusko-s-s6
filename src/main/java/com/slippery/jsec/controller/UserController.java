package com.slippery.jsec.controller;

import com.slippery.jsec.model.User;
import com.slippery.jsec.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService service;

    public UserController(UserService service){
        this.service=service;
    }
    @PostMapping ("/register")
    public User registerUser(@RequestBody User user){
        return service.createNewUser(user);
    }
}
