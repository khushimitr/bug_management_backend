package com.example.springbugtracker.repository;

import com.example.springbugtracker.model.domain.entity.User;
import jakarta.validation.constraints.Email;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface UserRepository extends JpaRepository<User, Integer> {
    Set<User> findDistinctByAssignedTeams_IdIn(Collection<Integer> ids);
    boolean existsByUserNameIgnoreCase(String userName);

    List<User> findAllByEmail(String email);
    List<User> findByEmailLikeIgnoreCaseOrUserNameLikeIgnoreCase(String email, String userName);

    Set<User> findByFirstNameContainsOrEmailContainsAndUserNameContainsAllIgnoreCase(String firstName, String email, String userName);



}