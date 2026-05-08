package com.project.hotelbooking.dto.response;

public record UserResponse(
    Long id,
    String email,
    String role
) {}
