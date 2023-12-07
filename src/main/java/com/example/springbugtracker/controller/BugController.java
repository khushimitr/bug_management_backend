package com.example.springbugtracker.controller;

import com.example.springbugtracker.model.domain.enums.BugPriority;
import com.example.springbugtracker.model.domain.enums.BugSeverity;
import com.example.springbugtracker.model.domain.enums.BugStatus;
import com.example.springbugtracker.model.dto.BugDto;
import com.example.springbugtracker.model.dto.ProjectDto;
import com.example.springbugtracker.model.dto.generalResponse.ApiResponse;
import com.example.springbugtracker.model.dto.generalResponse.ApiSuccessResponse;
import com.example.springbugtracker.service.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bug")
public class BugController {

    private final BugService bugService;

    @Autowired
    public BugController(BugService bugService) {
        this.bugService = bugService;
    }


    @GetMapping("/{bugId}/{projectId}")
    public ApiResponse<BugDto> getBugByIdAndProjectId(@PathVariable final Integer bugId, @PathVariable final Integer projectId) {
        return new ApiSuccessResponse<>(this.bugService.getBugByIdAndProjectId(bugId, projectId), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ApiResponse<BugDto> insertNewBug(@RequestBody BugDto bugDto) {
        return new ApiSuccessResponse<>(this.bugService.insertNewBug(bugDto), HttpStatus.CREATED);
    }

    @PatchMapping("/update/{id}")
    public ApiResponse<BugDto> updateBugById(@PathVariable final Integer id, @RequestBody final BugDto bugDto) {
        return new ApiSuccessResponse<>(this.bugService.updateBugById(id, bugDto), HttpStatus.OK);
    }

    @PatchMapping("/update/{id}/status")
    public ApiResponse<BugDto> updateBugStatus(@PathVariable final Integer id, @RequestBody final BugStatus bugStatus) {
        return new ApiSuccessResponse<>(this.bugService.updateBugStatus(id, bugStatus), HttpStatus.OK);
    }

    @PatchMapping("/update/{id}/severity")
    public ApiResponse<BugDto> updateBugSeverity(@PathVariable final Integer id, @RequestBody final BugSeverity bugSeverity) {
        return new ApiSuccessResponse<>(this.bugService.updateBugSeverity(id, bugSeverity), HttpStatus.OK);
    }

    @PatchMapping("/update/{id}/priority")
    public ApiResponse<BugDto> updateBugPriority(@PathVariable final Integer id, @RequestBody final BugPriority bugPriority) {
        return new ApiSuccessResponse<>(this.bugService.updateBugPriority(id, bugPriority), HttpStatus.OK);
    }
}
