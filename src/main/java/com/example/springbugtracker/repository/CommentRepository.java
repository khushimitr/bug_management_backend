package com.example.springbugtracker.repository;

import com.example.springbugtracker.model.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}