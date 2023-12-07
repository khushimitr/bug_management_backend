package com.example.springbugtracker.bussiness.auth.register.service.impl;

import com.example.springbugtracker.bussiness.auth.register.helper.RegistrationHelper;
import com.example.springbugtracker.bussiness.auth.register.model.RegisterRequest;
import com.example.springbugtracker.bussiness.auth.register.service.RegistrationService;
import com.example.springbugtracker.exception.registrartion.UsernameAlreadyExistsException;
import com.example.springbugtracker.model.domain.entity.User;
import com.example.springbugtracker.model.domain.enums.UserRole;
import com.example.springbugtracker.model.dto.UserDto;
import com.example.springbugtracker.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
@Slf4j
public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationHelper registrationHelper;
    private final UserRepository userRepository;

    @Autowired
    public RegistrationServiceImpl(RegistrationHelper registrationHelper, UserRepository userRepository) {
        this.registrationHelper = registrationHelper;
        this.userRepository = userRepository;
    }

    @Override
    public UserDto register(RegisterRequest registerRequest) {
        log.info("** Registering User.. **");

        if (this.userRepository.existsByUserNameIgnoreCase(registerRequest.getUserName())) {
            throw new UsernameAlreadyExistsException("Account with username : %s already exists".formatted(registerRequest.getUserName()));
        }

        log.info("** Unique username checked.. **");
        log.info(registerRequest.toString());
        return registerRequest.getRole().equals(UserRole.ROLE_MANAGER) ? this.registrationHelper.registerManager(registerRequest) : this.registrationHelper.registerEmployee(registerRequest);
    }


    @Override
    public String validateToken(String token) {
        return null;
    }

    @Override
    public UserDto resendToken(String username) {
        return null;
    }
}
