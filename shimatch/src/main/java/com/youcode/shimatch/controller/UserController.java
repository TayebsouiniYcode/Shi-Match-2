package com.youcode.shimatch.controller;

import com.youcode.shimatch.Entity.Match;
import com.youcode.shimatch.Entity.User;
import com.youcode.shimatch.service.MatchService;
import com.youcode.shimatch.service.UserService;
import com.youcode.shimatch.utils.MatchRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;
    private final MatchService matchService;

    public UserController(UserService userService, MatchService matchService) {
        this.userService = userService;
        this.matchService = matchService;
    }

    @PutMapping("/update/{id}")
    public User updateUser(@RequestBody User user, @PathVariable("id") Long id) throws Exception {
        return userService.updateUser(user, id);
    }

    @DeleteMapping("/delete/{id}")
    public int deleteUser(@PathVariable("id") Long id) throws  Exception {
        return userService.deleteUser(id);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        //test
        return userService.getAllUsers();
    }

    @PostMapping("/match")
    public Match matchRequest(@RequestBody MatchRequest matchRequest) throws Exception {
        return matchService.createMatch(matchRequest);
    }
}
