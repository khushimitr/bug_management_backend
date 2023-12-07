package com.example.springbugtracker.controller;

import com.example.springbugtracker.model.domain.entity.Role;
import com.example.springbugtracker.model.dto.RoleDto;
import com.example.springbugtracker.model.dto.generalResponse.ApiResponse;
import com.example.springbugtracker.model.dto.generalResponse.ApiSuccessResponse;
import com.example.springbugtracker.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }


    @PostMapping("/insert")
    public ApiResponse<RoleDto> insertNewRole(@RequestBody final Role role) {
        return new ApiSuccessResponse<>(this.roleService.insertNewRole(role), HttpStatus.CREATED);
    }


}
