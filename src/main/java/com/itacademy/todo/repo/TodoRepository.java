package com.itacademy.todo.repo;

import com.itacademy.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
    List<Todo> findAllByUserId(Integer userId);
    Optional<Todo> findById(Integer id);
}