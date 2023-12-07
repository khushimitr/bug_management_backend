package com.example.springbugtracker.bussiness.auth.authentication.controller;

import com.example.springbugtracker.bussiness.auth.authentication.service.LoginService;
import com.example.springbugtracker.model.dto.UserDto;
import com.example.springbugtracker.model.dto.generalResponse.ApiFailureResponse;
import com.example.springbugtracker.model.dto.generalResponse.ApiResponse;
import com.example.springbugtracker.model.dto.generalResponse.ApiSuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping("/user/login")
    public ApiResponse<UserDto> adminLogin(Authentication authentication) {
        List<UserDto> users = loginService.findAllByEmail(authentication.getName());
        if (!users.isEmpty()) {
            return new ApiSuccessResponse<>(users.get(0), HttpStatus.OK);
        } else {
            return new ApiFailureResponse<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/user/me")
    public ApiResponse<UserDto> getCurrentLoggedInUser(Authentication authentication) {
        List<UserDto> users = loginService.findAllByEmail(authentication.getName());
        if (!users.isEmpty()) {
            return new ApiSuccessResponse<>(users.get(0), HttpStatus.OK);
        } else {
            return new ApiFailureResponse<>(HttpStatus.NOT_FOUND);
        }
    }
}
