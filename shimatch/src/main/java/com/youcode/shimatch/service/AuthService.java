package com.youcode.shimatch.service;

import com.youcode.shimatch.dto.UserDto;
import com.youcode.shimatch.utils.LoginForm;
import com.youcode.shimatch.utils.ResponseMessage;

import java.util.List;

public interface AuthService {
    UserDto regiter(UserDto userDto);
    UserDto login(LoginForm loginForm);

    UserDto updateUser(UserDto userDto);
    ResponseMessage deleteUser(Long id);

    UserDto getUserById(Long id);

    List<UserDto> getAllUser();
}
