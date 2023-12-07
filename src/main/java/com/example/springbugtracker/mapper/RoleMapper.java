package com.example.springbugtracker.mapper;

import com.example.springbugtracker.model.domain.entity.Project;
import com.example.springbugtracker.model.domain.entity.Role;
import com.example.springbugtracker.model.domain.entity.Team;
import com.example.springbugtracker.model.domain.entity.User;
import com.example.springbugtracker.model.dto.ProjectDto;
import com.example.springbugtracker.model.dto.RoleDto;
import com.example.springbugtracker.model.dto.TeamDto;
import com.example.springbugtracker.model.dto.UserDto;
import org.mapstruct.*;

import java.util.Set;
import java.util.stream.Collectors;

import static com.example.springbugtracker.mapper.UserMapper.userSetToUserDtoSet;

public class RoleMapper {
    public static Role toEntity(RoleDto roleDto) {
        if (roleDto == null) {
            return null;
        }
        Role.RoleBuilder<?, ?> role = Role.builder();
        role.id(roleDto.getId());
        role.name(roleDto.getName());
        role.users(UserMapper.userDtoSetToUserEntitySet(roleDto.getUsers()));
        return role.build();
    }


    public static RoleDto toDto(Role role) {
        if (role == null) {
            return null;
        }

        RoleDto.RoleDtoBuilder<?, ?> roleDto = RoleDto.builder();

        roleDto.id(role.getId());
        roleDto.name(role.getName());
        roleDto.users(userSetToUserDtoSet(role.getUsers()));
        return roleDto.build();
    }

    public static RoleDto toDtoSmall(Role role) {
        if (role == null) {
            return null;
        }
        RoleDto.RoleDtoBuilder<?, ?> roleDto = RoleDto.builder();
        roleDto.id(role.getId());
        roleDto.name(role.getName());
        return roleDto.build();
    }


    public static Set<RoleDto> roleSetToRoleDtoSet(Set<Role> roleSet) {
        if (roleSet == null) {
            return null;
        }
        return roleSet.stream().map(RoleMapper::toDtoSmall).collect(Collectors.toSet());
    }

    public static Set<Role> roleDtoSetToRoleEntitySet(Set<RoleDto> roleDto) {
        if (roleDto == null)
            return null;
        return roleDto.stream().map(RoleMapper::toEntity).collect(Collectors.toSet());
    }


    public static Role partialUpdate(RoleDto roleDto, Role role) {
        if (roleDto == null) {
            return role;
        }
        if (roleDto.getId() != null)
            role.setId(roleDto.getId());
        if (roleDto.getName() != null)
            role.setName(roleDto.getName());
        if (roleDto.getUsers() != null)
            role.setUsers(UserMapper.userDtoSetToUserEntitySet(roleDto.getUsers()));
        return role;
    }

}