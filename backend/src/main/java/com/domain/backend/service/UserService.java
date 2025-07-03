package com.domain.backend.service;

import com.domain.backend.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User registerUser(User user);

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    User updateUser(String userId, User updatedUser);

    void deleteUser(String userId);

    List<User> getAllUsers();

    Optional<User> getUserById(String userId);
}
