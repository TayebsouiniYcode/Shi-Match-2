package com.youcode.shimatch.service;

import com.youcode.shimatch.Entity.Role;

import java.util.List;

public interface RoleService {
    Role getRoleById(Long id) throws Exception;

    List<Role> gettAllRole();

    Role createRole(Role role);

    Role updateRole(Role role);

    Integer deleteRoleById(Long id);
}
