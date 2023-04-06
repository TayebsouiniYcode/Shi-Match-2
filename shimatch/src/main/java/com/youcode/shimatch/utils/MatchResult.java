package com.youcode.shimatch.utils;

import lombok.Data;

@Data
public class MatchResult {
    Long id_match;
    Integer score_team1;
    Integer score_team2;
}
