package com.project.hotelbooking.services;

import com.project.hotelbooking.dto.requests.RegisterRequest;
import com.project.hotelbooking.dto.response.UserResponse;
import com.project.hotelbooking.mappers.UserMapper;
import com.project.hotelbooking.models.User;
import com.project.hotelbooking.models.enums.Role;
import com.project.hotelbooking.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserResponse registerUser(RegisterRequest registerRequest) {
        if (userRepository.existsByEmail(registerRequest.email())) {
            throw new RuntimeException("Email занят");
        }
        User user = User.builder()
            .email(registerRequest.email())
            .password(passwordEncoder.encode(registerRequest.password()))
            .role(Role.USER)
            .createdAt(LocalDate.now())
            .build();
        return userMapper.toUserResponse(userRepository.save(user));
    }
}
