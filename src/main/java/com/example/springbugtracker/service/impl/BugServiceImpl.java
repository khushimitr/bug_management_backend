package com.example.springbugtracker.service.impl;

import com.example.springbugtracker.exception.general.ResourceNotFoundException;
import com.example.springbugtracker.mapper.BugMapper;
import com.example.springbugtracker.mapper.UserMapper;
import com.example.springbugtracker.model.domain.entity.Bug;
import com.example.springbugtracker.model.domain.entity.User;
import com.example.springbugtracker.model.domain.enums.BugPriority;
import com.example.springbugtracker.model.domain.enums.BugSeverity;
import com.example.springbugtracker.model.domain.enums.BugStatus;
import com.example.springbugtracker.model.dto.BugDto;
import com.example.springbugtracker.model.dto.UserDto;
import com.example.springbugtracker.repository.BugRepository;
import com.example.springbugtracker.repository.ProjectRepository;
import com.example.springbugtracker.repository.UserRepository;
import com.example.springbugtracker.service.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class BugServiceImpl implements BugService {

    private final BugRepository bugRepository;

    private final UserRepository userRepository;


    @Autowired
    public BugServiceImpl(BugRepository bugRepository, UserRepository userRepository) {
        this.bugRepository = bugRepository;
        this.userRepository = userRepository;
    }

    private UserDto giveUser() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return UserMapper.toDto(this.userRepository.findAllByEmail(securityContext.getAuthentication().getName()).get(0));
    }

    private Bug giveBugById(Integer id) {
        return this.bugRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Bug", "bug id", id.toString()));
    }


    @Override
    public BugDto insertNewBug(BugDto bugDto) {
        Bug bug = BugMapper.toEntity(bugDto);
        return BugMapper.toDto(this.bugRepository.save(bug));
    }

    @Override
    public BugDto updateBugById(Integer id, BugDto bugDto) {
        Bug bug = this.giveBugById(id);
        bug = BugMapper.partialUpdate(bugDto, bug);
        return BugMapper.toDto(this.bugRepository.save(bug));
    }

    @Override
    public Set<BugDto> getAllBugsByProjectId(Integer id, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return BugMapper.bugSetToBugDtoSet(new HashSet<>(this.bugRepository.findDistinctByProject_Id(id, pageRequest)));
    }

    @Override
    public BugDto updateBugStatus(Integer id, BugStatus bugStatus) {
        Bug bug = this.giveBugById(id);
        bug.setBugStatus(bugStatus);
        return BugMapper.toDto(this.bugRepository.save(bug));
    }

    @Override
    public BugDto updateBugSeverity(Integer id, BugSeverity bugSeverity) {
        Bug bug = this.giveBugById(id);
        bug.setBugSeverity(bugSeverity);
        return BugMapper.toDto(this.bugRepository.save(bug));
    }

    @Override
    public BugDto updateBugPriority(Integer id, BugPriority bugPriority) {
        Bug bug = this.giveBugById(id);
        bug.setBugPriority(bugPriority);
        return BugMapper.toDto(this.bugRepository.save(bug));
    }

    @Override
    public BugDto assignBugToUser(Integer bugId, Integer userId) {
        Bug bug = this.giveBugById(bugId);
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "user id", userId.toString()));
        bug.setAssignee(user);
        return BugMapper.toDto(this.bugRepository.save(bug));
    }

    @Override
    public BugDto getBugByIdAndProjectId(Integer id, Integer projectId) {
        return BugMapper.toDto(this.bugRepository.findByIdAndProject_Id(id, projectId));
    }
}
