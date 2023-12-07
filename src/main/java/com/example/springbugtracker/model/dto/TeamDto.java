package com.example.springbugtracker.model.dto;

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
public class TeamDto {
    private Integer id;
    private String name;
    private UserDto manager;
    private Set<UserDto> members;
    private Set<ProjectDto> projects;
}
