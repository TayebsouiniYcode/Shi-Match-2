package com.youcode.shimatch.controller;

import com.youcode.shimatch.Entity.User;
import com.youcode.shimatch.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/update/{id}")
    public User updateUser(@RequestBody User user, @PathVariable("id") Long id) throws Exception {
        return userService.updateUser(user, id);
    }

    @DeleteMapping("/delete/{id}")
    public int deleteUser(@PathVariable("id") Long id) throws  Exception {
        return userService.deleteUser(id);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
