package com.example.springbugtracker.service;

import com.example.springbugtracker.model.domain.entity.Team;
import com.example.springbugtracker.model.dto.TeamDto;

import java.util.List;
import java.util.Set;

public interface TeamService {

    TeamDto insertNewTeam(TeamDto teamDto);

    TeamDto updateTeam(Integer id, TeamDto teamDto);

    TeamDto getTeamById(Integer id);

    TeamDto deleteTeamById(Integer id);

    TeamDto updateMembers(Integer id, TeamDto teamDto);

    Set<TeamDto> findByManager_Id(Integer id);

    List<TeamDto> findByProjects_Id(Integer id);
}
