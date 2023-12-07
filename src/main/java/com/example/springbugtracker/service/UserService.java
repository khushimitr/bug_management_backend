package com.example.springbugtracker.service;

import com.example.springbugtracker.model.domain.entity.User;
import com.example.springbugtracker.model.dto.UserDto;

import java.util.List;
import java.util.Set;

public interface UserService {
    UserDto insertNewUser(User user);

    List<UserDto> findAllByEmail(String email);

    List<UserDto> findAllByEmailOrUserName(String token);

    Set<UserDto> findByFirstNameContainsOrEmailContainsAndUserNameContainsAllIgnoreCase(String token);

    Set<UserDto> findDistinctUsersByProject_Id(Integer projectId);
}
