package com.example.springbugtracker.controller;

import com.example.springbugtracker.model.dto.CommentDto;
import com.example.springbugtracker.model.dto.generalResponse.ApiResponse;
import com.example.springbugtracker.model.dto.generalResponse.ApiSuccessResponse;
import com.example.springbugtracker.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/new")
    public ApiResponse<CommentDto> insertNewComment(@RequestBody final CommentDto commentDto) {
        return new ApiSuccessResponse<>(this.commentService.insertNewComment(commentDto), HttpStatus.CREATED);
    }

    @PatchMapping("/update/{id}")
    public ApiResponse<CommentDto> updateCommentById(@PathVariable final Integer id, @RequestBody final CommentDto commentDto) {
        return new ApiSuccessResponse<>(this.commentService.updateCommentById(id, commentDto), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse<CommentDto> deleteCommentById(@PathVariable final Integer id) {
        return new ApiSuccessResponse<>(this.commentService.deleteCommentById(id), HttpStatus.OK);
    }

}
