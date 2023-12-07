package com.example.springbugtracker.model.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
@EqualsAndHashCode
public class CommentDto {
    private Integer id;
    private String content;
    private UserDto commenter;
    private ProjectDto referredProject;
    private BugDto referredBug;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
