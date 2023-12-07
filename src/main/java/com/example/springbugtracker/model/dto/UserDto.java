package com.example.springbugtracker.model.dto;

import com.example.springbugtracker.model.domain.entity.*;
import com.example.springbugtracker.model.domain.enums.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
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
public class UserDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Boolean isEnabled;
    private Boolean isAccountNonExpired;
    private Boolean isAccountNonLocked;
    private Boolean isCredentialsNonExpired;
    private String phone;
    private String userName;
    private Boolean isMale;
    private RoleDto role;
    private String profileUrl;
    private Set<ProjectDto> projectsCreated;
    private Set<TeamDto> teamsManaged;
    private Set<TeamDto> assignedTeams;
    private Set<BugDto> bugsIdentified;
    private Set<BugDto> bugsAssigned;
    private Set<CommentDto> comments;

}
