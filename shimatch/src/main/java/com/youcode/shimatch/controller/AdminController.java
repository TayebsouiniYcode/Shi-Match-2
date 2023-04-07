package com.youcode.shimatch.controller;

import com.youcode.shimatch.Entity.User;
import com.youcode.shimatch.service.UserService;
import com.youcode.shimatch.utils.UpdateRoleRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin()
public class AdminController {
    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/updateRole")
    public User updateRoleForUsers(@RequestBody UpdateRoleRequest updateRoleRequest) throws Exception {
        return userService.updateUserRole(updateRoleRequest);
    }
}
