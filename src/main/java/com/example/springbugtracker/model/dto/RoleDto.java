package com.example.springbugtracker.model.dto;

import com.example.springbugtracker.model.domain.entity.User;
import com.example.springbugtracker.model.domain.enums.UserRole;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
@EqualsAndHashCode
public class RoleDto {
    private Integer id;
    private UserRole name;
    private Set<UserDto> users;
}
