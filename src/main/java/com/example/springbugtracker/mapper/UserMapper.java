package com.example.springbugtracker.mapper;

import com.example.springbugtracker.model.domain.entity.User;
import com.example.springbugtracker.model.dto.UserDto;
import com.example.springbugtracker.util.AppUtils;

import java.util.Set;
import java.util.stream.Collectors;


public class UserMapper {

    public static User toEntity(UserDto userDto) {
        if (userDto == null) {
            return null;
        }

        User.UserBuilder<?, ?> user = User.builder();

        user.id(userDto.getId());
        user.firstName(userDto.getFirstName());
        user.lastName(userDto.getLastName());
        user.email(userDto.getEmail());
        user.password(userDto.getPassword());
        user.isEnabled(userDto.getIsEnabled());
        user.isAccountNonExpired(userDto.getIsAccountNonExpired());
        user.isAccountNonLocked(userDto.getIsAccountNonLocked());
        user.isCredentialsNonExpired(userDto.getIsCredentialsNonExpired());
        user.phone(userDto.getPhone());
        user.userName(userDto.getUserName());
        user.isMale(userDto.getIsMale());
        user.role(RoleMapper.toEntity(userDto.getRole()));
        user.projectsCreated(ProjectMapper.projectDtoSetToProjectEntitySet(userDto.getProjectsCreated()));
        user.teamsManaged(TeamMapper.teamDtoSetToTeamEntitySet(userDto.getTeamsManaged()));
        user.assignedTeams(TeamMapper.teamDtoSetToTeamEntitySet(userDto.getAssignedTeams()));
        user.bugsIdentified(BugMapper.bugDtoSetToBugEntitySet(userDto.getBugsIdentified()));
        user.bugsAssigned(BugMapper.bugDtoSetToBugEntitySet(userDto.getBugsAssigned()));
        user.comments(CommentMapper.commentDtoSetToCommentEntitySet(userDto.getComments()));
        return user.build();
    }


    public static UserDto toDto(User user) {
        if (user == null) {
            return null;
        }

        UserDto.UserDtoBuilder<?, ?> userDto = UserDto.builder();

        userDto.id(user.getId());
        userDto.firstName(user.getFirstName());
        userDto.lastName(user.getLastName());
        userDto.email(user.getEmail());
        userDto.password(user.getPassword());
        userDto.isEnabled(user.getIsEnabled());
        userDto.isAccountNonExpired(user.getIsAccountNonExpired());
        userDto.isAccountNonLocked(user.getIsAccountNonLocked());
        userDto.isCredentialsNonExpired(user.getIsCredentialsNonExpired());
        userDto.phone(user.getPhone());
        userDto.userName(user.getUserName());
        userDto.profileUrl(user.getProfileUrl());
        userDto.isMale(user.getIsMale());
        userDto.role(RoleMapper.toDtoSmall(user.getRole()));
        userDto.projectsCreated(ProjectMapper.projectSetToProjectDtoSet(user.getProjectsCreated()));
        userDto.teamsManaged(TeamMapper.teamSetToTeamDtoSet(user.getTeamsManaged()));
        userDto.assignedTeams(TeamMapper.teamSetToTeamDtoSet(user.getAssignedTeams()));
        userDto.bugsIdentified(BugMapper.bugSetToBugDtoSet(user.getBugsIdentified()));
        userDto.bugsAssigned(BugMapper.bugSetToBugDtoSet(user.getBugsAssigned()));
        userDto.comments(CommentMapper.commentSetToCommentDtoSet(user.getComments()));
        return userDto.build();
    }

    public static UserDto toDtoSmall(User user) {
        if (user == null) {
            return null;
        }

        UserDto.UserDtoBuilder<?, ?> userDto = UserDto.builder();

        userDto.id(user.getId());
        userDto.firstName(user.getFirstName());
        userDto.lastName(user.getLastName());
        userDto.email(user.getEmail());
        userDto.password(user.getPassword());
        userDto.isEnabled(user.getIsEnabled());
        userDto.profileUrl(user.getProfileUrl());
        userDto.isAccountNonExpired(user.getIsAccountNonExpired());
        userDto.isAccountNonLocked(user.getIsAccountNonLocked());
        userDto.isCredentialsNonExpired(user.getIsCredentialsNonExpired());
        userDto.phone(user.getPhone());
        userDto.userName(user.getUserName());
        userDto.isMale(user.getIsMale());
        userDto.role(RoleMapper.toDtoSmall(user.getRole()));
        return userDto.build();
    }

    public static Set<UserDto> userSetToUserDtoSet(Set<User> users) {
        if (users == null)
            return null;
        return users.stream().map(UserMapper::toDtoSmall).collect(Collectors.toSet());
    }

    public static Set<User> userDtoSetToUserEntitySet(Set<UserDto> users) {
        if (users == null)
            return null;
        return users.stream().map(UserMapper::toEntity).collect(Collectors.toSet());
    }

    public static User partialUpdate(UserDto userDto, User user) {

        if (userDto == null) {
            return user;
        }

        if (userDto.getId() != null)
            user.setId(userDto.getId());
        if (userDto.getFirstName() != null)
            user.setFirstName(userDto.getFirstName());
        if (userDto.getLastName() != null)
            user.setLastName(userDto.getLastName());
        if (userDto.getEmail() != null)
            user.setEmail(userDto.getEmail());
        if (userDto.getPassword() != null)
            user.setPassword(userDto.getPassword());
        if (userDto.getProfileUrl() != null)
            user.setProfileUrl(userDto.getProfileUrl());
        if (userDto.getIsEnabled() != null)
            user.setIsEnabled(userDto.getIsEnabled());
        if (userDto.getIsAccountNonExpired() != null)
            user.setIsAccountNonExpired(userDto.getIsAccountNonExpired());
        if (userDto.getIsAccountNonLocked() != null)
            user.setIsAccountNonLocked(userDto.getIsAccountNonLocked());
        if (userDto.getIsCredentialsNonExpired() != null)
            user.setIsCredentialsNonExpired(userDto.getIsCredentialsNonExpired());
        if (userDto.getPhone() != null)
            user.setPhone(userDto.getPhone());
        if (userDto.getUserName() != null)
            user.setUserName(userDto.getUserName());
        if (userDto.getIsMale() != null)
            user.setIsMale(userDto.getIsMale());
        if (userDto.getRole() != null)
            user.setRole(RoleMapper.toEntity(userDto.getRole()));
        if (userDto.getProjectsCreated() != null)
            user.setProjectsCreated(ProjectMapper.projectDtoSetToProjectEntitySet(userDto.getProjectsCreated()));
        if (userDto.getTeamsManaged() != null)
            user.setTeamsManaged(TeamMapper.teamDtoSetToTeamEntitySet(userDto.getTeamsManaged()));
        if (userDto.getAssignedTeams() != null)
            user.setAssignedTeams(TeamMapper.teamDtoSetToTeamEntitySet(userDto.getAssignedTeams()));
        if (userDto.getBugsIdentified() != null)
            user.setBugsIdentified(BugMapper.bugDtoSetToBugEntitySet(userDto.getBugsIdentified()));
        if (userDto.getBugsAssigned() != null)
            user.setBugsAssigned(BugMapper.bugDtoSetToBugEntitySet(userDto.getBugsAssigned()));
        if (userDto.getComments() != null)
            user.setComments(CommentMapper.commentDtoSetToCommentEntitySet(userDto.getComments()));
        return user;
    }
}