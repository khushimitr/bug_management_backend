package com.example.springbugtracker.model.dto;

import com.example.springbugtracker.model.domain.entity.*;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
@EqualsAndHashCode
public class ProjectDto {
    private Integer id;
    private String projectKey;
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime targetEndDate;
    private LocalDateTime actualEndDate;
    private UserDto manager;
    private Set<BugDto> bugs;
    private Set<CommentDto> comments;
    private Set<TeamDto> teams;
}
