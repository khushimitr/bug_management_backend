package com.example.springbugtracker.service.impl;

import com.example.springbugtracker.exception.general.ResourceCanNotBeDeleteException;
import com.example.springbugtracker.exception.general.ResourceNotFoundException;
import com.example.springbugtracker.mapper.CommentMapper;
import com.example.springbugtracker.model.domain.entity.Comment;
import com.example.springbugtracker.model.dto.CommentDto;
import com.example.springbugtracker.repository.CommentRepository;
import com.example.springbugtracker.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    private Comment giveCommentById(Integer id) {
        return this.commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Comment", "comment id", id.toString()));
    }

    @Override
    public CommentDto insertNewComment(CommentDto commentDto) {
        Comment comment = CommentMapper.toEntity(commentDto);
        return CommentMapper.toDto(this.commentRepository.save(comment));
    }

    @Override
    public CommentDto updateCommentById(Integer id, CommentDto commentDto) {
        Comment comment = this.giveCommentById(id);
        comment = CommentMapper.partialUpdate(commentDto, comment);
        return CommentMapper.toDto(this.commentRepository.save(comment));
    }

    @Override
    public CommentDto deleteCommentById(Integer id) {
        Comment comment = this.giveCommentById(id);
        this.commentRepository.deleteById(id);
        if (!this.commentRepository.existsById(id))
            return CommentMapper.toDto(comment);
        else
            throw new ResourceCanNotBeDeleteException("Comment", "comment id", id.toString());
    }
}
