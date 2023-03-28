package com.youcode.shimatch.controller;

import com.youcode.shimatch.Entity.Role;
import com.youcode.shimatch.service.RoleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class RoleController {
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/role")
    public List<Role> getAllRole() {
        return roleService.gettAllRole();
    }

    @PostMapping("/role/add")
    public Role createRole(@RequestBody Role role) {
        return roleService.createRole(role);
    }
}
