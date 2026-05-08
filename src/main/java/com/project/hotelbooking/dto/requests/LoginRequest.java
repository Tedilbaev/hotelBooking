package com.project.hotelbooking.dto.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequest (
    @NotBlank(message = "{user.email.notBlank}")
    @Email(message = "{user.email.incorrectFormat}")
    String email,

    @NotBlank(message = "{user.password.notBlank}")
    String password
) {}
