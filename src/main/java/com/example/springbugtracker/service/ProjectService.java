package com.example.springbugtracker.service;

import com.example.springbugtracker.model.domain.entity.Project;
import com.example.springbugtracker.model.domain.entity.Team;
import com.example.springbugtracker.model.dto.ProjectDto;

import java.util.List;
import java.util.Set;

public interface ProjectService {
    ProjectDto insertNewProject(ProjectDto projectDto);

    ProjectDto updateProject(Integer id, ProjectDto project);

    ProjectDto getProjectById(Integer id);

    ProjectDto addTeamsToProject(Integer id, ProjectDto projectDto);

    Set<ProjectDto> findDistinctByManager_Id(Integer id);
}
