package com.itacademy.todo.service;

import com.itacademy.todo.model.Todo;
import com.itacademy.todo.model.User;
import com.itacademy.todo.repo.TodoRepository;
import com.itacademy.todo.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> fetchTodoList() {
        return todoRepository.findAll();
    }

    public List<Todo> fetchTodoListByUserId(Integer userId) {
        return todoRepository.findAllByUserId(userId);
    }
}
