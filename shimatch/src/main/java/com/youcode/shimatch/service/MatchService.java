package com.youcode.shimatch.service;

import com.youcode.shimatch.Entity.Match;
import com.youcode.shimatch.Entity.User;
import com.youcode.shimatch.utils.MatchRequest;
import com.youcode.shimatch.utils.MatchResult;

import java.security.Principal;
import java.util.List;

public interface MatchService {
    Match createMatch(MatchRequest matchRequest, Principal principal) throws Exception;
    Match updateMatch(Match match);
    int deleteMatch(Long id);
    Match findMatchById(Long id);
    List<Match> findAllMatch();

    Match matchResult(MatchResult matchResult) throws Exception;

    List<Match> getAllMatchByUser(User user);
}
