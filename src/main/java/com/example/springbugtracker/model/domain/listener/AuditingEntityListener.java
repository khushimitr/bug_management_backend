package com.example.springbugtracker.model.domain.listener;

import com.example.springbugtracker.model.domain.entity.common.AbstractAuditingMappedEntity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
public class AuditingEntityListener {
    @PrePersist
    public void preCreate(final AbstractAuditingMappedEntity auditable) {
        final var now = LocalDateTime.now();
        auditable.setCreatedAt(now);
        auditable.setUpdatedAt(now);
    }

    @PreUpdate
    public void preUpdate(final AbstractAuditingMappedEntity auditable) {
        final var now = LocalDateTime.now();
        auditable.setUpdatedAt(now);
    }
}
