package com.anoyi.user.controller;

import com.anoyi.user.entity.User;
import com.anoyi.user.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping("/user")
    public User addNewUser(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/user/{id}")
    public User findUserById(@PathVariable("id") Integer id) {
        return userService.selectById(id);
    }

}