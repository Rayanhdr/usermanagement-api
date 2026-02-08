package com.rayanhaidar.usermanagement.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
public class UserResponse {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
    private boolean enabled;
    private Instant createdAt;
}
