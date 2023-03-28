package com.youcode.shimatch.controller;

import com.youcode.shimatch.dto.UserDto;
import com.youcode.shimatch.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthRest {
     private final AuthService authService;

    public AuthRest(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public UserDto register(@RequestBody @Valid UserDto userDto) {
        return this.authService.regiter(userDto);
    }
}
