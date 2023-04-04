package com.youcode.shimatch.service;

import com.youcode.shimatch.Entity.Team;

import java.util.List;

public interface TeamService {
    Team createTeam(Team team) throws Exception;
    Team updateTeam(Team team) throws Exception;
    Team getTeamById(Long id) throws Exception;
    int deleteTeam(Long id) throws Exception;
    List<Team> getAllTeams();
}
