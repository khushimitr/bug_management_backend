package com.example.springbugtracker.bussiness.auth.register.model;

import com.example.springbugtracker.model.domain.entity.Role;
import com.example.springbugtracker.model.domain.enums.UserRole;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
@EqualsAndHashCode
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String userName;
    private Boolean isMale;
    private UserRole role;
}
