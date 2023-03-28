package com.youcode.shimatch.utils;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

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
