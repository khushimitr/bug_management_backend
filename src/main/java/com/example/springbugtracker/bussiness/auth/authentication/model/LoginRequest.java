package com.example.springbugtracker.bussiness.auth.authentication.model;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
        @NotBlank(message = "Input username should not be blank")
        String username,
        @NotBlank(message = "Input password should not be blank")
        String password) {
}
