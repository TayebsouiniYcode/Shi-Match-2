package com.youcode.shimatch.repository;

import com.youcode.shimatch.Entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
