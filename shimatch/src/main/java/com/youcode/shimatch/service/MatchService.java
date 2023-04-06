package com.youcode.shimatch.service;

import com.youcode.shimatch.Entity.Match;
import com.youcode.shimatch.utils.MatchRequest;

import java.util.List;

public interface MatchService {
    Match createMatch(MatchRequest matchRequest) throws Exception;
    Match updateMatch(Match match);
    int deleteMatch(Long id);
    Match findMatchById(Long id);
    List<Match> findAllMatch();
}
