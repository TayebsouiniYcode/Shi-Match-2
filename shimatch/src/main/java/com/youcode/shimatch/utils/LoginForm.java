package com.youcode.shimatch.utils;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginForm {
    @NotNull
    private final String email;
    @NotNull
    private final String password;

    public LoginForm(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
