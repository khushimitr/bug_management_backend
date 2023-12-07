package com.example.springbugtracker.model.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserRole {
    ROLE_MANAGER("ROLE_MANAGER", 1),
    ROLE_PROJECT_LEAD("ROLE_PROJECT_LEAD", 2),
    ROLE_TEAM_LEAD("ROLE_TEAM_LEAD", 3),
    ROLE_DEVELOPER("ROLE_DEVELOPER", 4),
    ROLE_TESTER("ROLE_TESTER", 5);
    private final String role;
    private final Integer id;

    public String getName() {
        return this.getRole().substring(5);
    }
}
