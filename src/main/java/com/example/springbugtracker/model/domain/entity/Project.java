package com.example.springbugtracker.model.domain.entity;

import com.example.springbugtracker.config.annotation.LocalDateTimeCustomFormat;
import com.example.springbugtracker.model.domain.entity.common.AbstractAuditingMappedEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

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
public class Project extends AbstractAuditingMappedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(unique = true, precision = 4, nullable = false)
    private String projectKey;

    @Column(nullable = false)
    @LocalDateTimeCustomFormat
    private LocalDateTime startDate;

    @LocalDateTimeCustomFormat
    private LocalDateTime targetEndDate;

    @LocalDateTimeCustomFormat
    private LocalDateTime actualEndDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private User manager;

    @OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
    @Column(nullable = true)
    @OrderBy("createdAt DESC")
    @ToString.Exclude
    private Set<Bug> bugs = new HashSet<>();

    @OneToMany(mappedBy = "referredProject", fetch = FetchType.LAZY)
    @Column(nullable = true)
    @ToString.Exclude
    private Set<Comment> comments = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "project_team",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    @ToString.Exclude
    private Set<Team> teams = new HashSet<>();
}
