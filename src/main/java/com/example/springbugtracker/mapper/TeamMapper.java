package com.example.springbugtracker.mapper;

import com.example.springbugtracker.model.domain.entity.Role;
import com.example.springbugtracker.model.domain.entity.Team;
import com.example.springbugtracker.model.dto.RoleDto;
import com.example.springbugtracker.model.dto.TeamDto;

import java.util.Set;
import java.util.stream.Collectors;

import static com.example.springbugtracker.mapper.ProjectMapper.projectSetToProjectDtoSet;
import static com.example.springbugtracker.mapper.UserMapper.userSetToUserDtoSet;


public class TeamMapper {

    public static Team toEntity(TeamDto teamDto) {
        if (teamDto == null) {
            return null;
        }

        Team.TeamBuilder<?, ?> team = Team.builder();

        team.id(teamDto.getId());
        team.name(teamDto.getName());
        team.manager(UserMapper.toEntity(teamDto.getManager()));
        team.members(UserMapper.userDtoSetToUserEntitySet(teamDto.getMembers()));
        team.projects(ProjectMapper.projectDtoSetToProjectEntitySet(teamDto.getProjects()));
        return team.build();
    }


    public static TeamDto toDto(Team team) {
        if (team == null) {
            return null;
        }

        TeamDto.TeamDtoBuilder<?, ?> teamDto = TeamDto.builder();

        teamDto.id(team.getId());
        teamDto.name(team.getName());
        teamDto.manager(UserMapper.toDtoSmall(team.getManager()));
        teamDto.members(userSetToUserDtoSet(team.getMembers()));
        teamDto.projects(projectSetToProjectDtoSet(team.getProjects()));
        return teamDto.build();
    }

    public static TeamDto toDtoSmall(Team team) {
        if (team == null) {
            return null;
        }

        TeamDto.TeamDtoBuilder<?, ?> teamDto = TeamDto.builder();

        teamDto.id(team.getId());
        teamDto.name(team.getName());

        return teamDto.build();
    }

    public static Set<TeamDto> teamSetToTeamDtoSet(Set<Team> assignedTeams) {
        if (assignedTeams == null) {
            return null;
        }
        return assignedTeams.stream().map(TeamMapper::toDtoSmall).collect(Collectors.toSet());
    }

    public static Set<Team> teamDtoSetToTeamEntitySet(Set<TeamDto> teamDto) {
        if (teamDto == null)
            return null;
        return teamDto.stream().map(TeamMapper::toEntity).collect(Collectors.toSet());
    }

    public static Team partialUpdate(TeamDto teamDto, Team team) {
        if (teamDto == null) {
            return team;
        }


        if (teamDto.getId() != null)
            team.setId(teamDto.getId());
        if (teamDto.getName() != null)
            team.setName(teamDto.getName());
        if (teamDto.getManager() != null)
            team.setManager(UserMapper.toEntity(teamDto.getManager()));
        if (teamDto.getMembers() != null)
            team.setMembers(UserMapper.userDtoSetToUserEntitySet(teamDto.getMembers()));
        if (teamDto.getProjects() != null)
            team.setProjects(ProjectMapper.projectDtoSetToProjectEntitySet(teamDto.getProjects()));
        return team;
    }


}
