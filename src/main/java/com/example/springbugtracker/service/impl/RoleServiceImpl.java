package com.example.springbugtracker.service.impl;

import com.example.springbugtracker.mapper.RoleMapper;
import com.example.springbugtracker.mapper.UserMapper;
import com.example.springbugtracker.model.domain.entity.Role;
import com.example.springbugtracker.model.dto.RoleDto;
import com.example.springbugtracker.repository.RoleRepository;
import com.example.springbugtracker.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleDto insertNewRole(Role role) {
        return RoleMapper.toDto(roleRepository.saveAndFlush(role));
    }
}
