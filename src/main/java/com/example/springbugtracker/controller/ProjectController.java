package com.example.springbugtracker.controller;

import com.example.springbugtracker.model.dto.ProjectDto;
import com.example.springbugtracker.model.dto.TeamDto;
import com.example.springbugtracker.model.dto.UserDto;
import com.example.springbugtracker.model.dto.generalResponse.ApiResponse;
import com.example.springbugtracker.model.dto.generalResponse.ApiSuccessResponse;
import com.example.springbugtracker.service.ProjectService;
import com.example.springbugtracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;
    private final UserService userService;

    @Autowired
    public ProjectController(ProjectService projectService, UserService userService) {
        this.projectService = projectService;
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ApiResponse<ProjectDto> getProjectById(@PathVariable final Integer id) {
        return new ApiSuccessResponse<>(this.projectService.getProjectById(id), HttpStatus.CREATED);
    }

    @PostMapping("/new")
    public ApiResponse<ProjectDto> insertNewProject(@RequestBody final ProjectDto projectDto) {
        return new ApiSuccessResponse<>(this.projectService.insertNewProject(projectDto), HttpStatus.CREATED);
    }

    @PatchMapping("/update/{id}")
    public ApiResponse<ProjectDto> updateProject(@PathVariable final Integer id, @RequestBody ProjectDto projectDto) {
        return new ApiSuccessResponse<>(this.projectService.updateProject(id, projectDto), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}/updateTeams")
    public ApiResponse<ProjectDto> addTeamsToProject(@PathVariable final Integer id, @RequestBody ProjectDto projectDto) {
        return new ApiSuccessResponse<>(this.projectService.addTeamsToProject(id, projectDto), HttpStatus.CREATED);
    }

    @GetMapping("/managed")
    public ApiResponse<Set<ProjectDto>> findTeamsByManager_Id() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        List<UserDto> allByEmail = this.userService.findAllByEmail(name);
        return new ApiSuccessResponse<>(this.projectService.findDistinctByManager_Id(allByEmail.get(0).getId()), HttpStatus.OK);
    }


}
