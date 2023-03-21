package com.youcode.shimatch.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.youcode.shimatch.Entity.Team} entity
 */
@Data
public class TeamDto implements Serializable {
    private final Long id;
    private final String name;
    private final String image;
    private final Integer win;
    private final Integer draw;
    private final Integer lose;
}