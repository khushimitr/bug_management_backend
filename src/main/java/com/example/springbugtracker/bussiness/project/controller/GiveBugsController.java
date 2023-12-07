package com.example.springbugtracker.bussiness.project.controller;

import com.example.springbugtracker.bussiness.project.service.GiveBugsService;
import com.example.springbugtracker.model.dto.ProjectDto;
import com.example.springbugtracker.model.dto.generalResponse.ApiResponse;
import com.example.springbugtracker.model.dto.generalResponse.ApiSuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/project-data")
public class GiveBugsController {

    private final GiveBugsService giveBugsService;

    @Autowired
    public GiveBugsController(GiveBugsService giveBugsService) {
        this.giveBugsService = giveBugsService;
    }

    @GetMapping("/")
    public ApiResponse<List<ProjectDto>> giveBugsOfAllProjects() {
        return new ApiSuccessResponse<>(this.giveBugsService.giveBugsOfAllProjects(), HttpStatus.OK);
    }

    @GetMapping("/{projectId}")
    public ApiResponse<ProjectDto> giveBugsOfProjectById(@PathVariable final Integer projectId) {
        return new ApiSuccessResponse<>(this.giveBugsService.giveBugsOfProjectById(projectId), HttpStatus.OK);
    }

}
