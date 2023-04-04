package com.youcode.shimatch.service.implementation;

import com.youcode.shimatch.Entity.Team;
import com.youcode.shimatch.repository.TeamRepository;
import com.youcode.shimatch.service.TeamService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Team createTeam(Team team) throws Exception {
        if (team != null && !team.equals(new Team())) {
            if (team.getName() != null && !team.getName().isEmpty() && !team.getName().isBlank()) {
                teamRepository.save(team);
                return team;
            } else {
                throw new Exception("Team name is empty or blank or null");
            }
        } else {
            throw new Exception("Team is null");
        }
    }

    @Override
    public Team updateTeam(Team team) throws Exception {
        if (team != null && !team.equals(new Team())) {
            //check if team exist in database
            Optional<Team> teamOptional = teamRepository.findById(team.getId());

            if (!teamOptional.isPresent()) throw new Exception("Team not found in database");

            teamRepository.save(team);

            return team;
        } else {
            throw new Exception("Team is null");
        }
    }

    @Override
    public Team getTeamById(Long id) throws Exception {
        Optional<Team> teamOptional = teamRepository.findById(id);
        if (!teamOptional.isPresent()) throw new Exception("Team not found in database");
        return teamOptional.get();
    }

    @Override
    public int deleteTeam(Long id) throws Exception {
        Optional<Team> teamOptional = teamRepository.findById(id);

        if (teamOptional.isPresent()) {
            try {
                teamRepository.delete(teamOptional.get());
                return 1;
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        } else {
            throw new Exception("Team not found in database");
        }
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }
}
