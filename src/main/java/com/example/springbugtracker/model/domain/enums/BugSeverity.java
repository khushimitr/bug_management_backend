package com.example.springbugtracker.model.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum BugSeverity {
    BLOCKER(0),
    CRITICAL(1),
    MAJOR(2),
    MINOR(3);

    private final Integer severity;
}
