package com.youcode.shimatch.service.implementation;

import com.youcode.shimatch.Entity.Role;
import com.youcode.shimatch.Entity.User;
import com.youcode.shimatch.dto.UserDto;
import com.youcode.shimatch.repository.RoleRepository;
import com.youcode.shimatch.repository.UserRepository;
import com.youcode.shimatch.service.UserService;
import com.youcode.shimatch.utils.LoginForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername (String email ) {
        User user = userRepository.findByEmail ( email );
        if (user == null ) {
            log.error ( "User not found" );
            throw  new UsernameNotFoundException( "User not found" );
        } else {
            log.info ( "User found in database : {} ", email );
        }

        System.out.println(user.toString());
        Collection< SimpleGrantedAuthority > authorities = new ArrayList <> (  );
        authorities.add(new SimpleGrantedAuthority((user.getRole().getName())));
        //on Role to many User
        return new org.springframework.security.core.userdetails.User (user.getEmail (), user.getPassword (), authorities  );
    }

    @Override
    public User register ( UserDto userDto ) throws Exception {
        User user = new User (  );
        if (userDto.getFirstname () != null && !userDto.getFirstname ().isEmpty ()) {
            if (userDto.getLastname () != null && !userDto.getLastname ().isEmpty ()) {
                if (userDto.getEmail () != null && !userDto.getEmail ().isEmpty ()) {
                    // TODO Test for optional email if exists or not
                    if ( userDto.getPassword () != null
                            && !userDto.getPassword ().isEmpty ()) {
                        try {
                            user.setFirstname ( userDto.getFirstname () );
                            user.setLastname ( userDto.getLastname () );
                            user.setEmail ( userDto.getEmail () );
                            user.setPassword ( userDto.getPassword () );
                            user.setPhone ( userDto.getPhone () );
                            user.setUsername ( userDto.getUsername () );

                            Role role = getRoleByName ( "ROLE_USER" );
                            user.setRole(role);
                            return userRepository.save ( user );
                        } catch (Exception e) {
                            throw new Exception(e.getMessage());
                        }
                    } else {
                        throw new Exception("Password null or empty");
                    }
                } else {
                    throw new Exception("Email null or empty");
                }
            } else {
                throw new Exception("Lastname null or empty");
            }
        } else {
            throw new Exception("Firstname null or empty");
        }
    }

    @Override
    public String login(LoginForm loginForm) {
        return null;
    }


    @Override
    public Optional< User > findByUsername (String username ) {
        return userRepository.findByUsername ( username );
    }

    @Override
    public User findByEmail ( String email ) {
        return userRepository.findByEmail ( email );
    }

    @Override
    public List< User > getAllUsers ( ) {
        return this.userRepository.findAll ();
    }

    @Override
    public Role getRoleByName ( String role_name ) {
        return this.roleRepository.getRoleByName ( role_name );
    }

    @Override
    public User save ( User user ) {
        return this.userRepository.save ( user );
    }
}
