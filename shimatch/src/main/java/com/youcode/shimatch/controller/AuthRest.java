package com.youcode.shimatch.controller;

import com.youcode.shimatch.dto.UserDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthRest {

    @PostMapping("/register")
    public UserDto register(@RequestBody UserDto userDto) {
        System.out.println(userDto.toString());
        return userDto;
    }
}
