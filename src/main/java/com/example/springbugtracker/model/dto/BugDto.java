package com.example.springbugtracker.model.dto;

import com.example.springbugtracker.model.domain.enums.BugPriority;
import com.example.springbugtracker.model.domain.enums.BugSeverity;
import com.example.springbugtracker.model.domain.enums.BugStatus;
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
public class BugDto {
    private Integer id;
    private Integer bugKey;
    private String summary;
    private String description;
    private BugStatus bugStatus;
    private BugSeverity bugSeverity;
    private BugPriority bugPriority;
    private LocalDateTime targetResolutionDate;
    private LocalDateTime actualResolutionDate;
    private String resolutionSummary;
    private UserDto identifier;
    private UserDto assignee;
    private ProjectDto project;
    private Set<CommentDto> comments;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}


