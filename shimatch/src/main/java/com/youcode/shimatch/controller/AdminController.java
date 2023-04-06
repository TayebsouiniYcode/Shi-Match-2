package com.youcode.shimatch.controller;

import com.youcode.shimatch.Entity.User;
import com.youcode.shimatch.service.UserService;
import com.youcode.shimatch.utils.UpdateRoleRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
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
