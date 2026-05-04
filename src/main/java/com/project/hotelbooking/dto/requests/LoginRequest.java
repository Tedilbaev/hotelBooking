package com.project.hotelbooking.dto.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data

public class LoginRequest {

    @NotBlank(message = "{user.email.notBlank}")
    @Email(message = "{user.email.incorrectFormat}")
    private String email;

    @NotBlank(message = "{user.password.notBlank}")
    private String password;
}
