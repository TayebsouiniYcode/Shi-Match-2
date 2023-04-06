package com.youcode.shimatch.utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class MatchRequest {
    Long id_user;
    Long id_team1;
    Long id_team2;
    Long id_Stadium;
    LocalDateTime date;
}
