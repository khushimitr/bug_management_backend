package com.example.springbugtracker.service;

import com.example.springbugtracker.model.domain.entity.Role;
import com.example.springbugtracker.model.dto.RoleDto;

public interface RoleService {
    RoleDto insertNewRole(Role role);
}
