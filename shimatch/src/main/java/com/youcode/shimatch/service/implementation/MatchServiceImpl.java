package com.youcode.shimatch.service.implementation;

import com.youcode.shimatch.Entity.Match;
import com.youcode.shimatch.Entity.Team;
import com.youcode.shimatch.Entity.User;
import com.youcode.shimatch.repository.MatchRepository;
import com.youcode.shimatch.service.MatchService;
import com.youcode.shimatch.service.TeamService;
import com.youcode.shimatch.service.UserService;
import com.youcode.shimatch.utils.MatchRequest;
import com.youcode.shimatch.utils.MatchResult;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
public class MatchServiceImpl implements MatchService {
    private final MatchRepository matchRepository;
    private final TeamService teamService;
    private final UserService userService;

    public MatchServiceImpl(MatchRepository matchRepository, TeamService teamService, UserService userService) {
        this.matchRepository = matchRepository;
        this.teamService = teamService;
        this.userService = userService;
    }

    @Override
    public Match createMatch(MatchRequest matchRequest, Principal principal) throws Exception {
        User user = userService.findByEmail(principal.getName());
        if(user == null || user.equals(new User())) throw new Exception("user not found in database");
        Optional<Team> team1Optional = teamService.getOptionalTeam(user.getTeam().getId());
        Optional<Team> team2Optional = teamService.getOptionalTeam(matchRequest.getId_team2());


        if (team1Optional.isEmpty()) throw new Exception("Team 1 not found in database");
        if (team2Optional.isEmpty()) throw new Exception("Team 2 not found in database");

        if (team1Optional.get().getCapitaine() != null && !team1Optional.get().getCapitaine().equals(user)) throw new Exception("You are not a capitaine of this team");

        if (matchRequest.getId_Stadium() != null) {
            //TODO check stadium if exist
        }

        Match match = new Match();
        LocalDateTime localDateTime = matchRequest.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        match.setDate(localDateTime);
        match.setTeam1(team1Optional.get());
        match.setTeam2(team2Optional.get());
        matchRepository.save(match);
        return match;
    }

    @Override
    public Match updateMatch(Match match) {
        return null;
    }

    @Override
    public int deleteMatch(Long id) {
        return 0;
    }

    @Override
    public Match findMatchById(Long id) {
        return null;
    }

    @Override
    public List<Match> findAllMatch() {
        return null;
    }

    @Override
    public Match matchResult(MatchResult matchResult) throws Exception {
        Optional<Match> matchOptional = matchRepository.findById(matchResult.getId_match());

        if (matchOptional.isEmpty()) throw new Exception("Match not found in database");

        matchOptional.get().setScoreTeam1(matchResult.getScore_team1());
        matchOptional.get().setScoreTeam2(matchResult.getScore_team2());

        matchRepository.save(matchOptional.get());
        return matchOptional.get();
    }

    @Override
    public List<Match> getAllMatchByUser(User user) {
        return this.matchRepository.findAllByTeam1(user.getTeam());
    }
}
