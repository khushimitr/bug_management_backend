package com.example.springbugtracker.mapper;

import com.example.springbugtracker.model.domain.entity.*;
import com.example.springbugtracker.model.dto.ProjectDto;

import java.util.Set;
import java.util.stream.Collectors;

public class ProjectMapper {

    public static Project toEntity(ProjectDto projectDto) {
        if (projectDto == null) {
            return null;
        }

        Project.ProjectBuilder<?, ?> project = Project.builder();

        project.id(projectDto.getId());
        project.projectKey(projectDto.getProjectKey());
        project.name(projectDto.getName());
        project.startDate(projectDto.getStartDate());
        project.targetEndDate(projectDto.getTargetEndDate());
        project.actualEndDate(projectDto.getActualEndDate());
        project.manager(UserMapper.toEntity(projectDto.getManager()));
        project.bugs(BugMapper.bugDtoSetToBugEntitySet(projectDto.getBugs()));
        project.comments(CommentMapper.commentDtoSetToCommentEntitySet(projectDto.getComments()));
        project.teams(TeamMapper.teamDtoSetToTeamEntitySet(projectDto.getTeams()));
        return project.build();
    }

    public static ProjectDto toDto(Project project) {
        if (project == null) {
            return null;
        }

        ProjectDto.ProjectDtoBuilder<?, ?> projectDto = ProjectDto.builder();

        projectDto.id(project.getId());
        projectDto.projectKey(project.getProjectKey());
        projectDto.name(project.getName());
        projectDto.startDate(project.getStartDate());
        projectDto.targetEndDate(project.getTargetEndDate());
        projectDto.actualEndDate(project.getActualEndDate());
        projectDto.manager(UserMapper.toDtoSmall(project.getManager()));
        projectDto.bugs(BugMapper.bugSetToBugDtoSet(project.getBugs()));
        projectDto.comments(CommentMapper.commentSetToCommentDtoSet(project.getComments()));
        projectDto.teams(TeamMapper.teamSetToTeamDtoSet(project.getTeams()));
        return projectDto.build();
    }

    public static ProjectDto toDtoSmall(Project project) {
        if (project == null) {
            return null;
        }

        ProjectDto.ProjectDtoBuilder<?, ?> projectDto = ProjectDto.builder();

        projectDto.id(project.getId());
        projectDto.projectKey(project.getProjectKey());
        projectDto.name(project.getName());
        projectDto.startDate(project.getStartDate());
        projectDto.targetEndDate(project.getTargetEndDate());
        projectDto.actualEndDate(project.getActualEndDate());
        return projectDto.build();
    }

    public static Set<ProjectDto> projectSetToProjectDtoSet(Set<Project> asProjectLead) {
        if (asProjectLead == null) {
            return null;
        }
        return asProjectLead.stream().map(ProjectMapper::toDtoSmall).collect(Collectors.toSet());
    }

    public static Set<Project> projectDtoSetToProjectEntitySet(Set<ProjectDto> projectDto) {
        if (projectDto == null)
            return null;
        return projectDto.stream().map(ProjectMapper::toEntity).collect(Collectors.toSet());
    }

    public static Project partialUpdate(ProjectDto projectDto, Project project) {
        if (projectDto == null) {
            return project;
        }

        if (projectDto.getId() != null)
            project.setId(projectDto.getId());
        if (projectDto.getProjectKey() != null)
            project.setProjectKey(projectDto.getProjectKey());
        if (projectDto.getName() != null)
            project.setName(projectDto.getName());
        if (projectDto.getStartDate() != null)
            project.setStartDate(projectDto.getStartDate());
        if (projectDto.getTargetEndDate() != null)
            project.setTargetEndDate(projectDto.getTargetEndDate());
        if (projectDto.getActualEndDate() != null)
            project.setActualEndDate(projectDto.getActualEndDate());
        if (projectDto.getManager() != null)
            project.setManager(UserMapper.toEntity(projectDto.getManager()));
        if (projectDto.getBugs() != null)
            project.setBugs(BugMapper.bugDtoSetToBugEntitySet(projectDto.getBugs()));
        if (projectDto.getComments() != null)
            project.setComments(CommentMapper.commentDtoSetToCommentEntitySet(projectDto.getComments()));
        if (projectDto.getTeams() != null)
            project.setTeams(TeamMapper.teamDtoSetToTeamEntitySet(projectDto.getTeams()));
        return project;
    }

}
