package com.example.springbugtracker.bussiness.auth.register.helper;

import com.example.springbugtracker.bussiness.auth.register.model.RegisterRequest;
import com.example.springbugtracker.mapper.UserMapper;
import com.example.springbugtracker.model.domain.entity.User;
import com.example.springbugtracker.model.dto.UserDto;
import com.example.springbugtracker.repository.RoleRepository;
import com.example.springbugtracker.repository.UserRepository;
import com.example.springbugtracker.util.AppUtils;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
@Slf4j
@Transactional
public class RegistrationHelper {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationHelper(RoleRepository roleRepository, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }


    public UserDto registerManager(final RegisterRequest registerRequest) {

        final var savedManager = this.userRepository.save(
                User.builder()
                        .firstName(registerRequest.getFirstName())
                        .lastName(registerRequest.getLastName())
                        .email(registerRequest.getEmail())
                        .phone(registerRequest.getPhone())
                        .userName(registerRequest.getUserName())
                        .isMale(registerRequest.getIsMale())
                        .profileUrl(AppUtils.giveAvatarUrl(registerRequest.getUserName() + registerRequest.getEmail()))
                        .password(this.passwordEncoder.encode(registerRequest.getPassword()))
                        .role(this.roleRepository.findById(registerRequest.getRole().getId()).orElseThrow(() -> new IllegalArgumentException("Role Did Not Match")))
                        .isEnabled(true) // should be false if additional token/OTP verification
                        .isAccountNonExpired(true)
                        .isAccountNonLocked(true)
                        .isCredentialsNonExpired(true)
                        .build());

        return UserMapper.toDto(savedManager);
    }

    public UserDto registerEmployee(final RegisterRequest registerRequest) {
        final var savedEmployee = this.userRepository.save(
                User.builder()
                        .firstName(registerRequest.getFirstName())
                        .lastName(registerRequest.getLastName())
                        .email(registerRequest.getEmail())
                        .phone(registerRequest.getPhone())
                        .userName(registerRequest.getUserName())
                        .isMale(registerRequest.getIsMale())
                        .profileUrl(AppUtils.giveAvatarUrl(registerRequest.getUserName() + registerRequest.getEmail()))
                        .password(this.passwordEncoder.encode(registerRequest.getPassword()))
                        .role(this.roleRepository.findById(registerRequest.getRole().getId()).orElseThrow(() -> new IllegalArgumentException("Role Did Not Match")))
                        .isEnabled(true) // should be false if additional token/OTP verification
                        .isAccountNonExpired(true)
                        .isAccountNonLocked(true)
                        .isCredentialsNonExpired(true)
                        .build());
        return UserMapper.toDto(savedEmployee);
    }


}
