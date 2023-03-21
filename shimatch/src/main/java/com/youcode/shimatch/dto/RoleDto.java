package com.youcode.shimatch.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.youcode.shimatch.Entity.Role} entity
 */
@Data
public class RoleDto implements Serializable {
    private final Long id;
    private final String name;
    private final String description;
}