package com.anoyi.user.controller;

import com.anoyi.user.entity.User;
import com.anoyi.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/add")
    public User addNewUser(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/all")
    public Iterable<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/find")
    public User findUserById(@RequestParam Integer id) {
        return userService.findById(id);
    }

}