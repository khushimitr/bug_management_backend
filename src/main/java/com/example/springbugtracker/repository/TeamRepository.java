package com.example.springbugtracker.repository;

import com.example.springbugtracker.model.domain.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface TeamRepository extends JpaRepository<Team, Integer> {
    List<Team> findByProjects_Id(Integer id);
    Set<Team> findByManager_Id(Integer id);

}