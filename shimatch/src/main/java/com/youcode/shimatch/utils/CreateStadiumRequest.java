package com.youcode.shimatch.utils;

import lombok.Data;

@Data
public class CreateStadiumRequest {
    Long id_owner;
    String name;
    String city;
    String country;
    String zipCode;
    String phone;
    String email;
}
