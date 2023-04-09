package com.youcode.shimatch.controller;

import com.youcode.shimatch.Entity.Stadium;
import com.youcode.shimatch.service.StadiumService;
import com.youcode.shimatch.utils.CreateStadiumRequest;
import org.springframework.web.bind.annotation.*;

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
    public Stadium createStadium(@RequestBody CreateStadiumRequest createStadiumRequest) throws Exception {
        return stadiumService.createStadium(createStadiumRequest);
    }

    @GetMapping("/byOwner/{id}")
    public List<Stadium> getAllStadiumByOwnerId(@PathVariable("id") Long id) {
        return stadiumService.getAllStadiumByOwnerId(id);
    }
}
