package com.spring.error.services;

import com.spring.error.models.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findById(Long id);
    List<User> findAll();
}
