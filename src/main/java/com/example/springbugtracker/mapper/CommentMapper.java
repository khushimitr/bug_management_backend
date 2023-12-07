package com.example.springbugtracker.mapper;

import com.example.springbugtracker.model.domain.entity.Bug;
import com.example.springbugtracker.model.domain.entity.Comment;
import com.example.springbugtracker.model.dto.BugDto;
import com.example.springbugtracker.model.dto.CommentDto;

import java.util.Set;
import java.util.stream.Collectors;

public class CommentMapper {
    public static Comment toEntity(CommentDto commentDto) {
        if (commentDto == null) {
            return null;
        }

        Comment.CommentBuilder<?, ?> comment = Comment.builder();

        comment.id(commentDto.getId());
        comment.content(commentDto.getContent());
        comment.commenter(UserMapper.toEntity(commentDto.getCommenter()));
        comment.referredProject(ProjectMapper.toEntity(commentDto.getReferredProject()));
        comment.referredBug(BugMapper.toEntity(commentDto.getReferredBug()));

        return comment.build();
    }


    public static CommentDto toDto(Comment comment) {
        if (comment == null) {
            return null;
        }

        CommentDto.CommentDtoBuilder<?, ?> commentDto = CommentDto.builder();

        commentDto.id(comment.getId());
        commentDto.content(comment.getContent());
        commentDto.createdAt(comment.getCreatedAt());
        commentDto.updatedAt(comment.getUpdatedAt());
        commentDto.commenter(UserMapper.toDto(comment.getCommenter()));
        commentDto.referredProject(ProjectMapper.toDtoSmall(comment.getReferredProject()));
        commentDto.referredBug(BugMapper.toDtoSmall(comment.getReferredBug()));
        return commentDto.build();
    }


    public static CommentDto toDtoSmall(Comment comment) {
        if (comment == null) {
            return null;
        }
        CommentDto.CommentDtoBuilder<?, ?> commentDto = CommentDto.builder();
        commentDto.id(comment.getId());
        commentDto.content(comment.getContent());
        commentDto.createdAt(comment.getCreatedAt());
        commentDto.updatedAt(comment.getUpdatedAt());
        commentDto.commenter(UserMapper.toDtoSmall(comment.getCommenter()));
        return commentDto.build();
    }

    public static Set<CommentDto> commentSetToCommentDtoSet(Set<Comment> comments) {
        if (comments == null) {
            return null;
        }
        return comments.stream().map(CommentMapper::toDtoSmall).collect(Collectors.toSet());
    }


    public static Set<Comment> commentDtoSetToCommentEntitySet(Set<CommentDto> commentDto) {
        if (commentDto == null)
            return null;
        return commentDto.stream().map(CommentMapper::toEntity).collect(Collectors.toSet());
    }

    public static Comment partialUpdate(CommentDto commentDto, Comment comment) {
        if (commentDto == null) {
            return comment;
        }

        if (commentDto.getId() != null)
            comment.setId(commentDto.getId());
        if (commentDto.getContent() != null)
            comment.setContent(commentDto.getContent());
        if (commentDto.getCommenter() != null)
            comment.setCommenter(UserMapper.toEntity(commentDto.getCommenter()));
        if (commentDto.getReferredProject() != null)
            comment.setReferredProject(ProjectMapper.toEntity(commentDto.getReferredProject()));
        if (commentDto.getReferredBug() != null)
            comment.setReferredBug(BugMapper.toEntity(commentDto.getReferredBug()));
        return comment;
    }


}


