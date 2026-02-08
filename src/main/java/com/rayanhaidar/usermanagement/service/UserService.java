package com.rayanhaidar.usermanagement.service;

import com.rayanhaidar.usermanagement.domain.entity.UserEntity;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserEntity create(UserEntity user);

    UserEntity getById(UUID id);

    List<UserEntity> getAll();
}
