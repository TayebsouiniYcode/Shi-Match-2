package com.youcode.shimatch.controller;

import com.youcode.shimatch.Entity.User;
import com.youcode.shimatch.dto.UserDto;
import com.youcode.shimatch.service.AuthService;
import com.youcode.shimatch.utils.LoginForm;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
public class AuthRest {
     private final AuthService authService;

    public AuthRest(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public UserDto register(@RequestBody @Valid UserDto userDto) throws Exception {
        return this.authService.regiter(userDto);
    }

    @GetMapping("/login")
    public User login(@RequestBody @Valid LoginForm loginForm) throws Exception {
        return this.authService.login(loginForm);
    }
}
