package com.youcode.shimatch.dto;

import com.youcode.shimatch.enums.FavoriteFoot;
import com.youcode.shimatch.enums.Poste;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.youcode.shimatch.Entity.User} entity
 */
@Data
public class UserDto implements Serializable {
    private final Long id;
    private final String lastname;
    private final String firstname;
    private final AddressDto address;
    private final LocalDateTime dateOfBirth;
    private final String phone;
    private final String email;
    private final String username;
    private final String password;
    private final String photo;
    private final Integer weight;
    private final Integer height;
    private final RoleDto role;
    private final Poste poste;
    private final FavoriteFoot favoriteFoot;
    private final TeamDto team;
}