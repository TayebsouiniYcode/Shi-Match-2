package com.youcode.shimatch.service.implementation;

import com.youcode.shimatch.Entity.Team;
import com.youcode.shimatch.Entity.User;
import com.youcode.shimatch.repository.TeamRepository;
import com.youcode.shimatch.service.TeamService;
import com.youcode.shimatch.service.UserService;
import com.youcode.shimatch.utils.DeletePlayerFromTeamRequest;
import com.youcode.shimatch.utils.JoinPlayerToTeam;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final UserService userService;

    public TeamServiceImpl(TeamRepository teamRepository, UserService userService) {
        this.teamRepository = teamRepository;
        this.userService = userService;
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
    public Optional<Team> getOptionalTeam(Long id) {
        return teamRepository.findById(id);
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

    @Override
    public Team addPlayerToTeam(JoinPlayerToTeam joinPlayerToTeam) throws Exception {
        //TODO check if player has team or not

        Optional<User> userOptional = userService.findById(joinPlayerToTeam.getId_user());
        Optional<Team> teamOptional = teamRepository.findById(joinPlayerToTeam.getId_team());

        if (userOptional.isEmpty()) throw new Exception("User not found in database");
        if (teamOptional.isEmpty()) throw new Exception("Team not found in database");



        //teamOptional.get().getUsers().add(userOptional.get());
        userOptional.get().setTeam(teamOptional.get());
        userService.save(userOptional.get());
        //teamRepository.save(teamOptional.get());
        return teamOptional.get();
    }

    @Override
    public Team deletePlayerFromTeam(DeletePlayerFromTeamRequest deletePlayerFromTeamRequest) throws Exception {
        Optional<Team> teamOptional = teamRepository.findById(deletePlayerFromTeamRequest.getId_team());
        if (teamOptional.isEmpty()) throw new Exception("Team not found in database");

        Optional<User> userOptional = userService.findById(deletePlayerFromTeamRequest.getId_player());
        if (userOptional.isEmpty()) throw new Exception("Player not found in database");

        teamOptional.get().getUsers().remove(userOptional.get());

        teamRepository.save(teamOptional.get());

        return teamOptional.get();
    }
}