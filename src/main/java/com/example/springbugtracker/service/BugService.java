package com.example.springbugtracker.service;

import com.example.springbugtracker.model.domain.entity.Bug;
import com.example.springbugtracker.model.domain.enums.BugPriority;
import com.example.springbugtracker.model.domain.enums.BugSeverity;
import com.example.springbugtracker.model.domain.enums.BugStatus;
import com.example.springbugtracker.model.dto.BugDto;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Set;

public interface BugService {
    BugDto insertNewBug(BugDto bugDto);

    BugDto updateBugById(Integer id, BugDto bugDto);

    Set<BugDto> getAllBugsByProjectId(Integer id, int page, int size);

    BugDto updateBugStatus(Integer id, BugStatus bugStatus);

    BugDto updateBugSeverity(Integer id, BugSeverity bugSeverity);

    BugDto updateBugPriority(Integer id, BugPriority bugPriority);

    BugDto assignBugToUser(Integer bugId, Integer userId);

    BugDto getBugByIdAndProjectId(Integer bugId, Integer projectId);
}
