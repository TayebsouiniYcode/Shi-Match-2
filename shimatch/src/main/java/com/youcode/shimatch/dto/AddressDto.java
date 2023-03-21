package com.youcode.shimatch.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.youcode.shimatch.Entity.Address} entity
 */
@Data
public class AddressDto implements Serializable {
    private final Long id;
    private final String country;
    private final String city;
    private final String address;
    private final String zipCode;
}