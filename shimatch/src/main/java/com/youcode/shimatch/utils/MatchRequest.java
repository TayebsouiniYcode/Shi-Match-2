package com.youcode.shimatch.utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class MatchRequest {
    Long id_user;
    Long id_team1;
    Long id_team2;
    Long id_Stadium;
    Date date;
}
