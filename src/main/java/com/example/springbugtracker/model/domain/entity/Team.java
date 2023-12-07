package com.example.springbugtracker.model.domain.entity;

import com.example.springbugtracker.model.domain.entity.common.AbstractAuditingMappedEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Cascade;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@SuperBuilder
public class Team extends AbstractAuditingMappedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private User manager;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "user_team",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    @ToString.Exclude
    private Set<User> members = new HashSet<>();

    @ManyToMany(mappedBy = "teams", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Project> projects = new HashSet<>();

}
