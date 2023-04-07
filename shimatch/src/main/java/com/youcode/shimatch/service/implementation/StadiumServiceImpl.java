package com.youcode.shimatch.service.implementation;

import com.youcode.shimatch.Entity.Stadium;
import com.youcode.shimatch.Entity.User;
import com.youcode.shimatch.repository.StadiumRepository;
import com.youcode.shimatch.service.StadiumService;
import com.youcode.shimatch.service.UserService;
import com.youcode.shimatch.utils.CreateStadiumRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StadiumServiceImpl implements StadiumService {
    private final StadiumRepository stadiumRepository;
    private final UserService userService;

    public StadiumServiceImpl(StadiumRepository stadiumRepository, UserService userService) {
        this.stadiumRepository = stadiumRepository;
        this.userService = userService;
    }

    @Override
    public Stadium createStadium(CreateStadiumRequest createStadiumRequest) throws Exception {
        //TODO refactoring
        Optional<User> userOptional = userService.findById(createStadiumRequest.getId_owner());

        if (userOptional.isEmpty()) throw new Exception("User not found in database");

        Stadium stadium = new Stadium();

        stadium.setOwner(userOptional.get());

        if (createStadiumRequest.getName() != null && !createStadiumRequest.getName().isEmpty()) stadium.setName(createStadiumRequest.getName());
        if (createStadiumRequest.getCity() != null && !createStadiumRequest.getCity().isEmpty()) stadium.setCity(createStadiumRequest.getCity());
        if (createStadiumRequest.getCountry() != null && !createStadiumRequest.getCountry().isEmpty()) stadium.setCountry(createStadiumRequest.getCountry());
        if (createStadiumRequest.getEmail() != null && !createStadiumRequest.getEmail().isEmpty()) stadium.setEmail(createStadiumRequest.getEmail());
        if (createStadiumRequest.getPhone() != null && !createStadiumRequest.getPhone().isEmpty()) stadium.setPhone(createStadiumRequest.getPhone());
        if (createStadiumRequest.getZipCode() != null && !createStadiumRequest.getZipCode().isEmpty()) stadium.setZipCode(createStadiumRequest.getZipCode());

        return stadiumRepository.save(stadium);
    }

    @Override
    public Stadium updateStadium(Stadium stadium) throws Exception {
        Optional<Stadium> stadiumOptional = stadiumRepository.findById(stadium.getId());

        if (stadiumOptional.isEmpty()) throw new Exception("Stadium not found in database");

        if (stadium.getName() != null && !stadium.getName().isEmpty()) stadiumOptional.get().setName(stadium.getName());
        stadiumRepository.save(stadiumOptional.get());
        return stadiumOptional.get();
    }

    @Override
    public Stadium getStadiumById(Long id) throws Exception {
        Optional<Stadium> stadiumOptional =  stadiumRepository.findById(id);
        if (stadiumOptional.isEmpty()) throw new Exception("Stadium not found in database");

        return stadiumOptional.get();
    }

    @Override
    public List<Stadium> getAllStadium() {
        return stadiumRepository.findAll();
    }

    @Override
    public int deleteStadium(Long id) throws Exception {
        Optional<Stadium> stadiumOptional = stadiumRepository.findById(id);

        if (stadiumOptional.isEmpty()) throw new Exception("Stadium not found in database");

        try {
            stadiumRepository.delete(stadiumOptional.get());
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
}
