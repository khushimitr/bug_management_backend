package com.example.springbugtracker.service;

import com.example.springbugtracker.model.dto.CommentDto;

public interface CommentService {
    CommentDto insertNewComment(CommentDto commentDto);

    CommentDto updateCommentById(Integer id, CommentDto commentDto);

    CommentDto deleteCommentById(Integer id);

}
