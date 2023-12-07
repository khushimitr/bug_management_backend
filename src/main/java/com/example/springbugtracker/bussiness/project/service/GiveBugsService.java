package com.example.springbugtracker.bussiness.project.service;

import com.example.springbugtracker.model.dto.ProjectDto;
import com.example.springbugtracker.model.dto.UserDto;

import java.util.List;

public interface GiveBugsService {

    UserDto getUser();

    List<ProjectDto> giveBugsOfAllProjects();

    ProjectDto giveBugsOfProjectById(Integer projectId);

}
