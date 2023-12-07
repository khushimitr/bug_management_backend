package com.example.springbugtracker.bussiness.auth.register.controller;

import com.example.springbugtracker.bussiness.auth.register.model.RegisterRequest;
import com.example.springbugtracker.bussiness.auth.register.service.RegistrationService;
import com.example.springbugtracker.model.domain.entity.User;
import com.example.springbugtracker.model.dto.UserDto;
import com.example.springbugtracker.model.dto.generalResponse.ApiFailureResponse;
import com.example.springbugtracker.model.dto.generalResponse.ApiResponse;
import com.example.springbugtracker.model.dto.generalResponse.ApiSuccessResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/register")
@Slf4j
public class RegistrationController {
    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    public ApiResponse<UserDto> register(@RequestBody @Valid final RegisterRequest registerRequest) {
        log.info("** Register user.. *");
        return new ApiSuccessResponse<>(registrationService.register(registerRequest), HttpStatus.CREATED);
    }
}
