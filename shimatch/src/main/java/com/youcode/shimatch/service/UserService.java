package com.youcode.shimatch.service;

import com.youcode.shimatch.Entity.Role;
import com.youcode.shimatch.Entity.Team;
import com.youcode.shimatch.Entity.User;
import com.youcode.shimatch.dto.UserDto;
import com.youcode.shimatch.utils.LoginForm;
import com.youcode.shimatch.utils.UpdateRoleRequest;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDetails loadUserByUsername(String email);
    User register (UserDto userDto ) throws Exception;
    String login ( LoginForm loginForm );

    Optional<User> findByUsername(String username);

    User findByEmail(String email);

    List<User> getAllUsers();

    Role getRoleByName(String role_name);

    User save ( User user );

    User updateUser(User user, Long id) throws Exception;

    int deleteUser(Long id);

    Optional<User> findById(Long id);

    User updateUserRole(UpdateRoleRequest updateRoleRequest) throws Exception;

}
