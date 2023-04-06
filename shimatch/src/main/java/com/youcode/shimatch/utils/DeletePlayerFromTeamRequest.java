package com.youcode.shimatch.utils;

import lombok.Data;

@Data
public class DeletePlayerFromTeamRequest {
    private Long id_player;
    private Long id_team;
}
