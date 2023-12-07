package com.example.springbugtracker.service.impl;

import com.example.springbugtracker.constant.AppConstant;
import com.example.springbugtracker.mapper.UserMapper;
import com.example.springbugtracker.model.domain.entity.User;
import com.example.springbugtracker.model.dto.TeamDto;
import com.example.springbugtracker.model.dto.UserDto;
import com.example.springbugtracker.repository.UserRepository;
import com.example.springbugtracker.service.TeamService;
import com.example.springbugtracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final TeamService teamService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, TeamService teamService) {
        this.userRepository = userRepository;
        this.teamService = teamService;
    }

    @Override
    public UserDto insertNewUser(User user) {
        return UserMapper.toDto(this.userRepository.saveAndFlush(user));
    }

    @Override
    public List<UserDto> findAllByEmail(String email) {
        return this.userRepository.findAllByEmail(email).stream().map(UserMapper::toDto).toList();
    }

    @Override
    public List<UserDto> findAllByEmailOrUserName(String token) {
        return this.userRepository.findByEmailLikeIgnoreCaseOrUserNameLikeIgnoreCase(token, token)
                .stream().map(UserMapper::toDto).limit(AppConstant.PAGE_SIZE).toList();
    }

    @Override
    public Set<UserDto> findByFirstNameContainsOrEmailContainsAndUserNameContainsAllIgnoreCase(String token) {
        return UserMapper.userSetToUserDtoSet(this.userRepository.findByFirstNameContainsOrEmailContainsAndUserNameContainsAllIgnoreCase(token, token, token));
    }

    @Override
    public Set<UserDto> findDistinctUsersByProject_Id(Integer projectId) {
        List<TeamDto> teamDtos = this.teamService.findByProjects_Id(projectId);
        List<Integer> teamIdsList = teamDtos.stream().map((TeamDto::getId)).toList();
        return this.userRepository.findDistinctByAssignedTeams_IdIn(teamIdsList).stream().map(UserMapper::toDto).collect(Collectors.toSet());
    }


}
