package com.example.springbugtracker.model.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum BugStatus {
    NEW(1, "new"),
    ASSIGNED(2, "assigned"),
    IN_PROGRESS(3, "in progress"),
    FIXED(4, "fixed"),
    PENDING_RETEST(5, "pending retest"),
    IN_RETEST(6, "retesting"),
    REOPEN(7, "reopen"),
    VERIFIED(8, "verified"),
    CLOSED(9, "closed"),
    DUPLICATE(10, "duplicate"),
    REJECTED(11, "rejected"),
    DEFERRED(12, "deferred"),
    NOT_A_BUG(13, "not a bug"),
    ;

    private final Integer statusCode;
    private final String statusValue;
}
