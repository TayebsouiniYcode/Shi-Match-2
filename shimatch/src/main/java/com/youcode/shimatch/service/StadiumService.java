package com.youcode.shimatch.service;

import com.youcode.shimatch.Entity.Stadium;
import com.youcode.shimatch.utils.CreateStadiumRequest;

import java.security.Principal;
import java.util.List;

public interface StadiumService {
    Stadium createStadium(CreateStadiumRequest stadium, Principal principal) throws Exception;
    Stadium updateStadium (Stadium stadium) throws Exception;
    Stadium getStadiumById(Long id) throws Exception;
    List<Stadium> getAllStadium();
    int deleteStadium(Long id) throws Exception;
    List<Stadium> getAllStadiumByOwnerId(Principal principal);
}
