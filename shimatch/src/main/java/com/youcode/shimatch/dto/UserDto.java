package com.youcode.shimatch.dto;

import com.youcode.shimatch.Entity.Address;
import com.youcode.shimatch.Entity.Role;
import com.youcode.shimatch.Entity.Team;
import com.youcode.shimatch.Entity.User;
import com.youcode.shimatch.enums.FavoriteFoot;
import com.youcode.shimatch.enums.Poste;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * A DTO for the {@link com.youcode.shimatch.Entity.User} entity
 */
@Data
public class UserDto implements Serializable {
    /*
    public UserDto(User user) {
        this.id = user.getId();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.email = user.getEmail();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.phone = user.getPhone();
        this.team = user.getTeam();
        this.role = user.getRole();
        this.address = user.getAddress();
        this.weight = user.getWeight();
        this.height = user.getHeight();
        this.favoriteFoot = user.getFavoriteFoot();
        this.dateOfBirth = user.getDateOfBirth();
        this.phone = user.getPhone();
    }
    */
    private final Long id;

    @NotNull(message = "Firstname cannot be null") @NotBlank
    @Size(min = 3, max = 50, message = "Size of firstname between 8 and 50")
    private  String firstname;

    @NotNull(message = "Lastname cannot be null")
    @Size(min = 3, max = 50,  message = "Size of lastname between 8 and 50")
    private final String lastname;

    private final Address address;

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

    private final Role role;

    private final Poste poste;

    private final FavoriteFoot favoriteFoot;

    private final Team team;
}