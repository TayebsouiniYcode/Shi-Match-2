package com.youcode.shimatch.service;

import com.youcode.shimatch.Entity.Team;
import com.youcode.shimatch.utils.DeletePlayerFromTeamRequest;
import com.youcode.shimatch.utils.JoinPlayerToTeam;

import java.util.List;

public interface TeamService {
    Team createTeam(Team team) throws Exception;
    Team updateTeam(Team team) throws Exception;
    Team getTeamById(Long id) throws Exception;
    int deleteTeam(Long id) throws Exception;
    List<Team> getAllTeams();

    Team addPlayerToTeam(JoinPlayerToTeam joinPlayerToTeam) throws Exception;
    Team deletePlayerFromTeam(DeletePlayerFromTeamRequest deletePlayerFromTeamRequest) throws Exception;
}
