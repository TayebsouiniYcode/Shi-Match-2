package com.youcode.shimatch.repository;

import com.youcode.shimatch.Entity.Match;
import com.youcode.shimatch.Entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {
    List<Match> findAllByTeam1(Team team);
}
