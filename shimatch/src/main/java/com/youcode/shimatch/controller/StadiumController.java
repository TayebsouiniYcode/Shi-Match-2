package com.youcode.shimatch.controller;

import com.youcode.shimatch.Entity.Stadium;
import com.youcode.shimatch.service.StadiumService;
import com.youcode.shimatch.utils.CreateStadiumRequest;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/stadium")
@CrossOrigin()
public class StadiumController {
    private final StadiumService stadiumService;

    public StadiumController(StadiumService stadiumService) {
        this.stadiumService = stadiumService;
    }

    @GetMapping("/stadiums")
    public List<Stadium> getAllStadium(){
        return stadiumService.getAllStadium();
    }

    @GetMapping("/{id}")
    public Stadium getStadiumById(@PathVariable("id") Long id) throws Exception {
        return stadiumService.getStadiumById(id);
    }

    @DeleteMapping("/delete/{id}")
    public int deleteStadiumById(@PathVariable("id") Long id) throws Exception {
        return stadiumService.deleteStadium(id);
    }

    @PutMapping("/update")
    public Stadium updateStadium(@RequestBody Stadium stadium) throws Exception {
        return stadiumService.updateStadium(stadium);
    }

    @PostMapping("/create")
    public Stadium createStadium(@RequestBody CreateStadiumRequest createStadiumRequest, Principal principal) throws Exception {
        return stadiumService.createStadium(createStadiumRequest, principal);
    }

    @GetMapping("/byOwner")
    public List<Stadium> getAllStadiumByOwnerId(Principal principal) {
        return stadiumService.getAllStadiumByOwnerId(principal);
    }
}
