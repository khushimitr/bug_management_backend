package com.example.springbugtracker.bussiness.auth.register.service;

import com.example.springbugtracker.bussiness.auth.register.model.RegisterRequest;
import com.example.springbugtracker.model.domain.entity.User;
import com.example.springbugtracker.model.dto.UserDto;

public interface RegistrationService {
    UserDto register(final RegisterRequest registerRequest);

    String validateToken(final String token);

    UserDto resendToken(final String username);
}
