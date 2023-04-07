package com.youcode.shimatch.controller;

import com.youcode.shimatch.Entity.User;
import com.youcode.shimatch.dto.UserDto;
import com.youcode.shimatch.security.JwtUtils;
import com.youcode.shimatch.service.UserService;
import com.youcode.shimatch.utils.LoginForm;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@CrossOrigin()
public class AuthRest {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtils jwtUtils;
    private final UserService userService;

    public AuthRest(AuthenticationManager authenticationManager, UserDetailsService userDetailsService, JwtUtils jwtUtils, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtils = jwtUtils;
        this.userService = userService;
    }

    @PostMapping("/login")
    public String authenticate( @RequestBody LoginForm loginForm) {
        authenticationManager.authenticate (
                new UsernamePasswordAuthenticationToken( loginForm.getEmail (), loginForm.getPassword () )
        );
        final UserDetails userDetails = userDetailsService.loadUserByUsername ( loginForm.getEmail ( ) );
        return jwtUtils.generateToken ( userDetails );
    }

    @PostMapping("/register")
    public ResponseEntity< User > register(@RequestBody UserDto user) throws Exception {
        return ResponseEntity.ok (userService.register (user));
    }
}
