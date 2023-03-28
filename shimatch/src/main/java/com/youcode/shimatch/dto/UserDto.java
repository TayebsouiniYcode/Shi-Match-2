package com.youcode.shimatch.dto;

import com.youcode.shimatch.enums.FavoriteFoot;
import com.youcode.shimatch.enums.Poste;
import jakarta.validation.constraints.*;
import lombok.Data;


import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.youcode.shimatch.Entity.User} entity
 */
@Data
public class UserDto implements Serializable {
    private final Long id;

    @NotNull(message = "Firstname cannot be null") @NotBlank
    @Size(min = 3, max = 50, message = "Size of firstname between 8 and 50")
    private  String firstname;

    @NotNull(message = "Lastname cannot be null")
    @Size(min = 3, max = 50,  message = "Size of lastname between 8 and 50")
    private final String lastname;

    private final AddressDto address;

    @Past(message = "Date of birth should be valid")
    private final LocalDateTime dateOfBirth;

    @NotNull
    private final String phone;

    @Email(message = "Email should be valid")
    private final String email;

    @NotNull(message = "Username cannot be null")
    @NotEmpty(message = "Username cannot be empty")
    private final String username;

    @NotNull(message = "Password cannot be null")
    private final String password;

    private final String photo;

    private final Integer weight;

    private final Integer height;

    private final RoleDto role;

    private final Poste poste;

    private final FavoriteFoot favoriteFoot;

    private final TeamDto team;
}