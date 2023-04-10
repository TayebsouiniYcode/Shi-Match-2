package com.youcode.shimatch.controller;

import com.youcode.shimatch.Entity.Team;
import com.youcode.shimatch.service.TeamService;
import com.youcode.shimatch.utils.DeletePlayerFromTeamRequest;
import com.youcode.shimatch.utils.JoinPlayerToTeam;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/team")
@CrossOrigin()
public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/teams")
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/{id}")
    public Team getTeamById(@PathVariable("id") Long id) throws Exception {
        //TODO Refactoring
        Team team = teamService.getTeamById(id);
        return team;
    }

    @PutMapping("/update")
    public Team updateTeam(@RequestBody Team team) throws Exception {
        return teamService.updateTeam(team);
    }

    @DeleteMapping("/delete/{id}")
    public int deleteTeam(@PathVariable("id") Long id) throws Exception {
        return teamService.deleteTeam(id);
    }

    @PostMapping("/create")
    public Team createTeam(@RequestBody Team team) throws Exception {
        return teamService.createTeam(team);
    }

    @PostMapping("/addPlayer")
    public Team addPlayerToTeam(@RequestBody JoinPlayerToTeam joinPlayerToTeam) throws Exception {
        return teamService.addPlayerToTeam(joinPlayerToTeam);
    }

    @DeleteMapping("/deletePlayer")
    public Team deletePlayerFromTeam(@RequestBody DeletePlayerFromTeamRequest deletePlayerFromTeamRequest) throws  Exception {
        return teamService.deletePlayerFromTeam(deletePlayerFromTeamRequest);
    }

    @GetMapping("/hasTeam/{email}")
    public Boolean hasTeam(@PathVariable("email") String email) {
        return this.teamService.hasTeam(email);
    }
}
