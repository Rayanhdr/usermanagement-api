package com.rayanhaidar.usermanagement.mapper;

import com.rayanhaidar.usermanagement.domain.entity.UserEntity;
import com.rayanhaidar.usermanagement.domain.UserRole;
import com.rayanhaidar.usermanagement.dto.request.CreateUserRequest;
import com.rayanhaidar.usermanagement.dto.response.UserResponse;

public class UserMapper {

    private UserMapper() {
        // utility class
    }

    // =========================
    // REQUEST → ENTITY
    // =========================
    public static UserEntity toEntity(CreateUserRequest request) {
        UserEntity user = new UserEntity();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword()); // hashing later
        user.setRole(UserRole.USER);
        user.setEnabled(true);
        return user;
    }

    // =========================
    // ENTITY → RESPONSE
    // =========================
    public static UserResponse toResponse(UserEntity user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setFirstName(user.getFirstName());
        response.setLastName(user.getLastName());
        response.setEmail(user.getEmail());
        response.setRole(user.getRole().name());
        response.setEnabled(user.isEnabled());
        response.setCreatedAt(user.getCreatedAt());
        return response;
    }
}
