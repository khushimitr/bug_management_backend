package com.example.springbugtracker.repository;

import com.example.springbugtracker.model.domain.entity.Project;
import com.example.springbugtracker.model.domain.entity.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
    Set<Project> findDistinctByManager_Id(Integer id);

    List<Project> findDistinctByTeams_Members_Id(Integer id, PageRequest pageRequest);

    List<Project> findByTeams_Members_Id(Integer id);

    Optional<Project> findByIdAndTeams_Manager_Id(Integer projectId, Integer userId);




}