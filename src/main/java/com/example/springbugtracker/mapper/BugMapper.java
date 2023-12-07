package com.example.springbugtracker.mapper;

import com.example.springbugtracker.model.domain.entity.Bug;
import com.example.springbugtracker.model.domain.entity.User;
import com.example.springbugtracker.model.dto.BugDto;
import com.example.springbugtracker.model.dto.UserDto;

import java.util.Set;
import java.util.stream.Collectors;

import static com.example.springbugtracker.mapper.CommentMapper.commentSetToCommentDtoSet;

public class BugMapper {

    public static Bug toEntity(BugDto bugDto) {
        if (bugDto == null) {
            return null;
        }

        Bug.BugBuilder<?, ?> bug = Bug.builder();

        bug.id(bugDto.getId());
        bug.bugKey(bugDto.getBugKey());
        bug.summary(bugDto.getSummary());
        bug.description(bugDto.getDescription());
        bug.bugStatus(bugDto.getBugStatus());
        bug.bugSeverity(bugDto.getBugSeverity());
        bug.bugPriority(bugDto.getBugPriority());
        bug.targetResolutionDate(bugDto.getTargetResolutionDate());
        bug.actualResolutionDate(bugDto.getActualResolutionDate());
        bug.resolutionSummary(bugDto.getResolutionSummary());
        bug.identifier(UserMapper.toEntity(bugDto.getIdentifier()));
        bug.assignee(UserMapper.toEntity(bugDto.getAssignee()));
        bug.project(ProjectMapper.toEntity(bugDto.getProject()));
        bug.comments(CommentMapper.commentDtoSetToCommentEntitySet(bugDto.getComments()));
        return bug.build();
    }

    public static BugDto toDto(Bug bug) {
        if (bug == null) {
            return null;
        }
        BugDto.BugDtoBuilder<?, ?> bugDto = BugDto.builder();
        bugDto.id(bug.getId());
        bugDto.bugKey(bug.getBugKey());
        bugDto.summary(bug.getSummary());
        bugDto.description(bug.getDescription());
        bugDto.bugStatus(bug.getBugStatus());
        bugDto.bugSeverity(bug.getBugSeverity());
        bugDto.bugPriority(bug.getBugPriority());
        bugDto.targetResolutionDate(bug.getTargetResolutionDate());
        bugDto.actualResolutionDate(bug.getActualResolutionDate());
        bugDto.resolutionSummary(bug.getResolutionSummary());
        bugDto.createdAt(bug.getCreatedAt());
        bugDto.updatedAt(bug.getUpdatedAt());
        bugDto.identifier(UserMapper.toDtoSmall(bug.getIdentifier()));
        bugDto.assignee(UserMapper.toDtoSmall(bug.getAssignee()));
        bugDto.project(ProjectMapper.toDtoSmall(bug.getProject()));
        bugDto.comments(CommentMapper.commentSetToCommentDtoSet(bug.getComments()));
        return bugDto.build();
    }


    public static BugDto toDtoSmall(Bug bug) {
        if (bug == null) {
            return null;
        }
        BugDto.BugDtoBuilder<?, ?> bugDto = BugDto.builder();
        bugDto.id(bug.getId());
        bugDto.bugKey(bug.getBugKey());
        bugDto.bugStatus(bug.getBugStatus());
        bugDto.bugSeverity(bug.getBugSeverity());
        bugDto.bugPriority(bug.getBugPriority());
        bugDto.createdAt(bug.getCreatedAt());
        bugDto.updatedAt(bug.getUpdatedAt());
        bugDto.targetResolutionDate(bug.getTargetResolutionDate());
        bugDto.actualResolutionDate(bug.getActualResolutionDate());
        return bugDto.build();
    }

    public static Set<BugDto> bugSetToBugDtoSet(Set<Bug> bugsIdentified) {
        if (bugsIdentified == null) {
            return null;
        }
        return bugsIdentified.stream().map(BugMapper::toDto).collect(Collectors.toSet());
    }

    public static Set<Bug> bugDtoSetToBugEntitySet(Set<BugDto> bugDtos) {
        if (bugDtos == null)
            return null;
        return bugDtos.stream().map(BugMapper::toEntity).collect(Collectors.toSet());
    }

    public static Bug partialUpdate(BugDto bugDto, Bug bug) {
        if (bugDto == null) {
            return bug;
        }
        if (bugDto.getId() != null)
            bug.setId(bugDto.getId());
        if (bugDto.getBugKey() != null)
            bug.setBugKey(bugDto.getBugKey());
        if (bugDto.getSummary() != null)
            bug.setSummary(bugDto.getSummary());
        if (bugDto.getDescription() != null)
            bug.setDescription(bugDto.getDescription());
        if (bugDto.getBugStatus() != null)
            bug.setBugStatus(bugDto.getBugStatus());
        if (bugDto.getBugSeverity() != null)
            bug.setBugSeverity(bugDto.getBugSeverity());
        if (bugDto.getBugPriority() != null)
            bug.setBugPriority(bugDto.getBugPriority());
        if (bugDto.getTargetResolutionDate() != null)
            bug.setTargetResolutionDate(bugDto.getTargetResolutionDate());
        if (bugDto.getActualResolutionDate() != null)
            bug.setActualResolutionDate(bugDto.getActualResolutionDate());
        if (bugDto.getResolutionSummary() != null)
            bug.setResolutionSummary(bugDto.getResolutionSummary());
        if (bugDto.getIdentifier() != null)
            bug.setIdentifier(UserMapper.toEntity(bugDto.getIdentifier()));
        if (bugDto.getAssignee() != null)
            bug.setAssignee(UserMapper.toEntity(bugDto.getAssignee()));
        if (bugDto.getProject() != null)
            bug.setProject(ProjectMapper.toEntity(bugDto.getProject()));
        if (bugDto.getComments() != null)
            bug.setComments(CommentMapper.commentDtoSetToCommentEntitySet(bugDto.getComments()));
        return bug;
    }

}
