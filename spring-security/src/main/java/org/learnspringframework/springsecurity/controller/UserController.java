package org.learnspringframework.springsecurity.controller;

import org.learnspringframework.springsecurity.model.Users;
import org.learnspringframework.springsecurity.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public Users registerUser(@RequestBody Users users){
        return userService.register(users);
    }


    @GetMapping("/users")
    public List<Users> getAllUsers(){
        return userService.getAllUsers();
    }

}
