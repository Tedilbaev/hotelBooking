package com.project.hotelbooking.services;

import com.project.hotelbooking.dto.requests.LoginRequest;
import com.project.hotelbooking.dto.requests.RegisterRequest;
import com.project.hotelbooking.dto.response.AuthResponse;
import com.project.hotelbooking.dto.response.UserResponse;
import com.project.hotelbooking.mappers.UserMapper;
import com.project.hotelbooking.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final UserMapper userMapper;

    public AuthResponse register(RegisterRequest registerRequest) {
        UserResponse userResponse = userService.registerUser(registerRequest);
        String token = jwtUtil.generateToken(userResponse.email());
        return userMapper.toAuthResponse(token, userResponse);
    }

    public AuthResponse login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtil.generateToken(loginRequest.email());
        String role = authentication.getAuthorities().stream()
                .findFirst()
                .map(GrantedAuthority::getAuthority)
                .orElse("ROLE_USER");
        return new AuthResponse(token, loginRequest.email(), role);
    }
}
