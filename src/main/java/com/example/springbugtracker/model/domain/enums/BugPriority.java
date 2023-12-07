package com.example.springbugtracker.model.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BugPriority {
    HIGH(0),
    MEDIUM(1),
    LOW(2);

    private final Integer priority;
}
