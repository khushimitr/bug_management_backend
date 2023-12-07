package com.example.springbugtracker.repository;

import com.example.springbugtracker.model.domain.entity.Bug;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BugRepository extends JpaRepository<Bug, Integer> {
    List<Bug> findDistinctByProject_Id(Integer id, PageRequest pageRequest);



    Bug findByIdAndProject_Id(Integer bugId, Integer projectId);
}