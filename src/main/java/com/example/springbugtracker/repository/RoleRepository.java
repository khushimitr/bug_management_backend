package com.example.springbugtracker.repository;

import com.example.springbugtracker.model.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}