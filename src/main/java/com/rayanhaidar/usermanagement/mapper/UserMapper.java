package com.rayanhaidar.usermanagement.mapper;

import com.rayanhaidar.usermanagement.domain.UserRole;
import com.rayanhaidar.usermanagement.domain.entity.UserEntity;
import com.rayanhaidar.usermanagement.dto.request.CreateUserRequest;
import com.rayanhaidar.usermanagement.dto.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", imports = UserRole.class)
public interface UserMapper {
    // =========================
    // REQUEST → ENTITY
    // =========================
    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "role", expression = "java(UserRole.USER)"),
            @Mapping(target = "enabled", constant = "true"),
            @Mapping(target = "createdAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true)
    })
    UserEntity toEntity(CreateUserRequest request);

    // =========================
    // ENTITY → RESPONSE
    // =========================
    @Mapping(target = "role", expression = "java(user.getRole().name())")
    UserResponse toResponse(UserEntity user);
}
