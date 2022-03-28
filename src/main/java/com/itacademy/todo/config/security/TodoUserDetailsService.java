package com.itacademy.todo.config.security;

import com.itacademy.todo.model.User;
import com.itacademy.todo.repo.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TodoUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public TodoUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
        return new TodoUserPrincipal(user);
    }
}
