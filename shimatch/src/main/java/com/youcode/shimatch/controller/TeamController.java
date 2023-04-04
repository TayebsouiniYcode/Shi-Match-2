package com.youcode.shimatch.controller;

import com.youcode.shimatch.Entity.Team;
import com.youcode.shimatch.service.TeamService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/team")
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
        return teamService.getTeamById(id);
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
}
