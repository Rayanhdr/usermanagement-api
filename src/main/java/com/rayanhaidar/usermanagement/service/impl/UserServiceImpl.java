package com.rayanhaidar.usermanagement.service.impl;

import com.rayanhaidar.usermanagement.domain.entity.UserEntity;
import com.rayanhaidar.usermanagement.exception.DuplicateResourceException;
import com.rayanhaidar.usermanagement.exception.ResourceNotFoundException;
import com.rayanhaidar.usermanagement.repository.UserRepository;
import com.rayanhaidar.usermanagement.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserEntity create(UserEntity user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new DuplicateResourceException("Email already exists");
        }

        // HASH PASSWORD
        user.setPassword(
                passwordEncoder.encode(user.getPassword())
        );

        return userRepository.save(user);
    }

    @Override
    public UserEntity getById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }
}
