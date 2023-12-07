package com.example.springbugtracker.bussiness.auth.authentication.service;

import com.example.springbugtracker.model.domain.entity.User;
import com.example.springbugtracker.model.dto.UserDto;

import java.util.List;

public interface LoginService {
    List<UserDto> findAllByEmail(String email);
}
