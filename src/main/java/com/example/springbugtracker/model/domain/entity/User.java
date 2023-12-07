package com.example.springbugtracker.model.domain.entity;

import com.example.springbugtracker.model.domain.entity.common.AbstractAuditingMappedEntity;
import com.example.springbugtracker.model.domain.enums.UserRole;
import com.example.springbugtracker.model.domain.listener.AuditingEntityListener;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EntityListeners(AuditingEntityListener.class)
public class User extends AbstractAuditingMappedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Email
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Boolean isEnabled;

    @Column(nullable = false)
    private Boolean isAccountNonExpired;

    @Column(nullable = false)
    private Boolean isAccountNonLocked;

    @Column(nullable = false)
    private Boolean isCredentialsNonExpired;

    @Column(precision = 10)
    private String phone;

    @Column(nullable = false)
    private String userName;

    private Boolean isMale;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String profileUrl;

    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;

    @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Project> projectsCreated = new HashSet<>();

    @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Team> teamsManaged = new HashSet<>();

    @ManyToMany(mappedBy = "members", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Team> assignedTeams = new HashSet<>();

    @OneToMany(mappedBy = "identifier", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Bug> bugsIdentified = new HashSet<>();

    @OneToMany(mappedBy = "assignee", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Bug> bugsAssigned = new HashSet<>();

    @OneToMany(mappedBy = "commenter", fetch = FetchType.LAZY)
    @ToString.Exclude
    private Set<Comment> comments = new HashSet<>();
}
