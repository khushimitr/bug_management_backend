package com.example.springbugtracker.bussiness.auth.authentication.service.impl;

import com.example.springbugtracker.bussiness.auth.authentication.service.LoginService;
import com.example.springbugtracker.mapper.UserMapper;
import com.example.springbugtracker.model.domain.entity.User;
import com.example.springbugtracker.model.dto.UserDto;
import com.example.springbugtracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    private final UserRepository userRepository;

    @Autowired
    public LoginServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> findAllByEmail(String email) {
        return userRepository.findAllByEmail(email).stream().map(UserMapper::toDto).toList();
    }
}
