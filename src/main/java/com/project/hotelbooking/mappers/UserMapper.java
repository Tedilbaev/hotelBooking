package com.project.hotelbooking.mappers;

import com.project.hotelbooking.dto.response.AuthResponse;
import com.project.hotelbooking.dto.response.UserResponse;
import com.project.hotelbooking.models.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    AuthResponse toAuthResponse(String token, UserResponse userResponse);

    UserResponse toUserResponse(User user);
}
