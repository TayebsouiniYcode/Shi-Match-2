package com.youcode.shimatch.repository;

import com.youcode.shimatch.Entity.Stadium;
import com.youcode.shimatch.Entity.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StadiumRepository extends JpaRepository<Stadium, Long> {
    List<Stadium> findByOwner(User owner);
}
