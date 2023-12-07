package com.example.springbugtracker.model.domain.entity;

import com.example.springbugtracker.model.domain.entity.common.AbstractAuditingMappedEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuperBuilder
public class Comment extends AbstractAuditingMappedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private User commenter;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Project referredProject;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Bug referredBug;

}
