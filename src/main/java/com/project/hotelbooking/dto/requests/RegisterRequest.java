package com.project.hotelbooking.dto.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequest (
    @NotBlank(message = "{user.email.notBlank}")
    @Email(message = "{user.email.incorrectFormat}")
    String email,

    @NotBlank(message = "{user.password.notBlank}")
    @Size(min = 6, message = "{user.password.minSize}")
    String password
) {}
