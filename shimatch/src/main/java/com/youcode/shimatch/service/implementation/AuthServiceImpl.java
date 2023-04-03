package com.youcode.shimatch.service.implementation;

import com.youcode.shimatch.Entity.Role;
import com.youcode.shimatch.Entity.User;
import com.youcode.shimatch.dto.UserDto;
import com.youcode.shimatch.repository.UserRepository;
import com.youcode.shimatch.service.AuthService;
import com.youcode.shimatch.service.RoleService;
import com.youcode.shimatch.utils.LoginForm;
import com.youcode.shimatch.utils.ResponseMessage;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RoleService roleService;

    public AuthServiceImpl(UserRepository userRepository, ModelMapper modelMapper, RoleService roleService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.roleService = roleService;
    }

    @Override
    public UserDto regiter(UserDto userDto) throws Exception {
        //TODO check the userDto if valide
        //Validation manuel de userDTO
        User user = modelMapper.map(userDto, User.class);
        Role role = roleService.getRoleById(2L);
        user.setRole(role);
        userRepository.save(user);
        return userDto;
    }

    @Override
    public User login(LoginForm loginForm) throws Exception {
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
