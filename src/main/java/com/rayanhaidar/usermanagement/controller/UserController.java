package com.rayanhaidar.usermanagement.controller;

import com.rayanhaidar.usermanagement.domain.entity.UserEntity;
import com.rayanhaidar.usermanagement.domain.UserRole;
import com.rayanhaidar.usermanagement.dto.request.CreateUserRequest;
import com.rayanhaidar.usermanagement.dto.response.UserResponse;
import com.rayanhaidar.usermanagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.rayanhaidar.usermanagement.mapper.UserMapper;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // =========================
    // CREATE USER
    // =========================
    @PostMapping
    public ResponseEntity<UserResponse> createUser(
            @Valid @RequestBody CreateUserRequest request
    ) {
        UserEntity user = UserMapper.toEntity(request);
        UserEntity savedUser = userService.create(user);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(UserMapper.toResponse(savedUser));
    }

    // =========================
    // GET USER BY ID
    // =========================
    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable UUID id) {
        return ResponseEntity.ok(
                UserMapper.toResponse(userService.getById(id))
        );
    }

    // =========================
    // GET ALL USERS
    // =========================
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return ResponseEntity.ok(
                userService.getAll()
                        .stream()
                        .map(UserMapper::toResponse)
                        .toList()
        );
    }
}
