package com.itacademy.todo.service;

import com.itacademy.todo.config.security.TodoUserPrincipal;
import com.itacademy.todo.model.User;
import com.itacademy.todo.repo.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> fetchUser(Integer id) {
        return userRepository.findById(id);
    }

    public User fetchCurrentUser() {
        return ((TodoUserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
    }
}
