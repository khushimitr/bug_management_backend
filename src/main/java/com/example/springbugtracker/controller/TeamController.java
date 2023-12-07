package com.example.springbugtracker.controller;

import com.example.springbugtracker.model.dto.TeamDto;
import com.example.springbugtracker.model.dto.UserDto;
import com.example.springbugtracker.model.dto.generalResponse.ApiResponse;
import com.example.springbugtracker.model.dto.generalResponse.ApiSuccessResponse;
import com.example.springbugtracker.service.TeamService;
import com.example.springbugtracker.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/team")
@Slf4j
public class TeamController {
    private final TeamService teamService;
    private final UserService userService;

    @Autowired
    public TeamController(TeamService teamService, UserService userService) {
        this.teamService = teamService;
        this.userService = userService;
    }

    @PostMapping("/new")
    public ApiResponse<TeamDto> insertNewTeam(@RequestBody final TeamDto teamDto) {
        return new ApiSuccessResponse<>(this.teamService.insertNewTeam(teamDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ApiResponse<TeamDto> getTeamById(@PathVariable final Integer id) {
        return new ApiSuccessResponse<>(this.teamService.getTeamById(id), HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    public ApiResponse<TeamDto> updateTeam(@PathVariable Integer id, @RequestBody TeamDto team) {
        team.setId(id);
        return new ApiSuccessResponse<>(this.teamService.updateTeam(id, team), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}/updateMembers")
    public ApiResponse<TeamDto> updateMembers(@PathVariable final Integer id, @RequestBody TeamDto teamDto) {
        return new ApiSuccessResponse<>(this.teamService.updateMembers(id, teamDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse<TeamDto> deleteTeamById(@PathVariable final Integer id) {
        return new ApiSuccessResponse<>(this.teamService.deleteTeamById(id), HttpStatus.OK);
    }

    @GetMapping("/managed")
    public ApiResponse<Set<TeamDto>> findTeamsByManager_Id() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        List<UserDto> allByEmail = this.userService.findAllByEmail(name);
        return new ApiSuccessResponse<>(this.teamService.findByManager_Id(allByEmail.get(0).getId()), HttpStatus.OK);
    }

}
