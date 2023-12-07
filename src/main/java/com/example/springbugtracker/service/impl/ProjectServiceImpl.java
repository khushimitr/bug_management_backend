package com.example.springbugtracker.service.impl;

import com.example.springbugtracker.exception.general.ResourceNotFoundException;
import com.example.springbugtracker.mapper.ProjectMapper;
import com.example.springbugtracker.model.domain.entity.Project;
import com.example.springbugtracker.model.domain.entity.Team;
import com.example.springbugtracker.model.domain.entity.User;
import com.example.springbugtracker.model.dto.ProjectDto;
import com.example.springbugtracker.repository.ProjectRepository;
import com.example.springbugtracker.repository.RoleRepository;
import com.example.springbugtracker.repository.TeamRepository;
import com.example.springbugtracker.repository.UserRepository;
import com.example.springbugtracker.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    private Project giveProjectById(Integer id) {
        return this.projectRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Project", "project id", id.toString()));
    }

    @Override
    public ProjectDto insertNewProject(ProjectDto projectDto) {
        Project project = ProjectMapper.toEntity(projectDto);
        return ProjectMapper.toDto(this.projectRepository.save(project));
    }

    @Override
    public ProjectDto updateProject(Integer id, ProjectDto projectDto) {
        Project project = this.giveProjectById(id);
        project = ProjectMapper.partialUpdate(projectDto, project);
        return ProjectMapper.toDto(this.projectRepository.save(project));
    }

    @Override
    public ProjectDto getProjectById(Integer id) {
        return ProjectMapper.toDto(this.giveProjectById(id));
    }

    @Override
    public ProjectDto addTeamsToProject(Integer id, ProjectDto projectDto) {
        Project project = this.giveProjectById(id);
        project = ProjectMapper.partialUpdate(projectDto, project);
        return ProjectMapper.toDto(this.projectRepository.save(project));
    }

    @Override
    public Set<ProjectDto> findDistinctByManager_Id(Integer id) {
        return ProjectMapper.projectSetToProjectDtoSet(this.projectRepository.findDistinctByManager_Id(id));
    }
}
