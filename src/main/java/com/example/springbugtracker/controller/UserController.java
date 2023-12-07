package com.example.springbugtracker.controller;

import com.example.springbugtracker.model.dto.UserDto;
import com.example.springbugtracker.model.dto.generalResponse.ApiResponse;
import com.example.springbugtracker.model.dto.generalResponse.ApiSuccessResponse;
import com.example.springbugtracker.service.ProjectService;
import com.example.springbugtracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/like")
    public ApiResponse<Set<UserDto>> getAllUsersLike(@RequestParam() final String token) {
        return new ApiSuccessResponse<>(this.userService.findByFirstNameContainsOrEmailContainsAndUserNameContainsAllIgnoreCase(token), HttpStatus.OK);
    }

    @GetMapping("/in-project/{projectId}")
    public ApiResponse<Set<UserDto>> getAllUsersInAProject(@PathVariable Integer projectId) {
        return new ApiSuccessResponse<>(this.userService.findDistinctUsersByProject_Id(projectId), HttpStatus.OK);
    }
}
