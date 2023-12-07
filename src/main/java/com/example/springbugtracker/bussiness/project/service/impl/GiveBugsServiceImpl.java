package com.example.springbugtracker.bussiness.project.service.impl;

import com.example.springbugtracker.bussiness.project.service.GiveBugsService;
import com.example.springbugtracker.exception.general.ResourceNotFoundException;
import com.example.springbugtracker.mapper.ProjectMapper;
import com.example.springbugtracker.mapper.UserMapper;
import com.example.springbugtracker.model.dto.ProjectDto;
import com.example.springbugtracker.model.dto.UserDto;
import com.example.springbugtracker.repository.ProjectRepository;
import com.example.springbugtracker.repository.UserRepository;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiveBugsServiceImpl implements GiveBugsService {

    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;

    public GiveBugsServiceImpl(UserRepository userRepository, ProjectRepository projectRepository) {
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public UserDto getUser() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return UserMapper.toDto(this.userRepository.findAllByEmail(securityContext.getAuthentication().getName()).get(0));
    }

    @Override
    public List<ProjectDto> giveBugsOfAllProjects() {
        UserDto userDto = this.getUser();
        return this.projectRepository.findByTeams_Members_Id(userDto.getId()).stream().map(ProjectMapper::toDto).toList();
    }

    @Override
    public ProjectDto giveBugsOfProjectById(Integer projectId) {
        UserDto userDto = this.getUser();
        return ProjectMapper.toDto(this.projectRepository.findByIdAndTeams_Manager_Id(projectId, userDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Project", "project and user ", "%s, %s".formatted(projectId, userDto.getId()))));
    }

}
