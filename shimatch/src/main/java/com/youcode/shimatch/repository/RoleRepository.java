package com.youcode.shimatch.repository;

import com.youcode.shimatch.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findRoleById(Long id);
    @Query("SELECT r FROM Role r WHERE r.name=?1")
    public Role getRoleByName(String role_name);

}
