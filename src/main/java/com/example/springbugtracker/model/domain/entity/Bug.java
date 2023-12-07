package com.example.springbugtracker.model.domain.entity;

import com.example.springbugtracker.config.annotation.BugKeyGenerator;
import com.example.springbugtracker.model.domain.entity.common.AbstractAuditingMappedEntity;
import com.example.springbugtracker.model.domain.enums.BugPriority;
import com.example.springbugtracker.model.domain.enums.BugSeverity;
import com.example.springbugtracker.model.domain.enums.BugStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.IdentifierGenerator;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuperBuilder
public class Bug extends AbstractAuditingMappedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false, updatable = false)
    @BugKeyGenerator
    private Integer bugKey;

    @Column(columnDefinition = "TEXT")
    private String summary;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private BugStatus bugStatus;

    @Enumerated(EnumType.STRING)
    private BugSeverity bugSeverity;

    @Enumerated(EnumType.STRING)
    private BugPriority bugPriority;

    private LocalDateTime targetResolutionDate;

    private LocalDateTime actualResolutionDate;

    @Column(columnDefinition = "TEXT")
    private String resolutionSummary;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private User identifier;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private User assignee;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Project project;

    @OneToMany(mappedBy = "referredBug", fetch = FetchType.LAZY)
    @OrderBy("createdAt DESC")
    @ToString.Exclude
    private Set<Comment> comments = new HashSet<>();
}
