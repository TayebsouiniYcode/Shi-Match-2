package com.youcode.shimatch.service.implementation;

import com.youcode.shimatch.Entity.Address;
import com.youcode.shimatch.Entity.User;
import com.youcode.shimatch.dto.AddressDto;
import com.youcode.shimatch.dto.UserDto;
import com.youcode.shimatch.repository.UserRepository;
import com.youcode.shimatch.service.AuthService;
import com.youcode.shimatch.utils.LoginForm;
import com.youcode.shimatch.utils.ResponseMessage;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public AuthServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto regiter(UserDto userDto) {
        //TODO check the userDto if valide
        //Validation manuel de userDTO
        User user = modelMapper.map(userDto, User.class);
        userRepository.save(user);
        return userDto;
    }

    @Override
    public UserDto login(LoginForm loginForm) {
        return null;
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return null;
    }

    @Override
    public ResponseMessage deleteUser(Long id) {
        return null;
    }

    @Override
    public UserDto getUserById(Long id) {
        return null;
    }

    @Override
    public List<UserDto> getAllUser() {
        return null;
    }
}
