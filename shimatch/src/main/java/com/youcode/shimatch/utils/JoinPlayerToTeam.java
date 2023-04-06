package com.youcode.shimatch.utils;

import com.youcode.shimatch.Entity.User;
import lombok.Data;

@Data
public class JoinPlayerToTeam {
    private Long id_user;
    private Long id_team;
}
