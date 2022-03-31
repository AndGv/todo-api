package com.itacademy.todo.service;

import com.itacademy.todo.exception.FailedToEditException;
import com.itacademy.todo.model.Todo;
import com.itacademy.todo.repo.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final UserService userService;

    public TodoService(TodoRepository todoRepository, UserService userService) {
        this.todoRepository = todoRepository;
        this.userService = userService;
    }

    public List<Todo> fetchCurrentUserTodoList() {
        return todoRepository.findAllByUserId(userService.fetchCurrentUser().getId());
    }

    public Todo updateTodo(Todo todo) {
        Todo existingTodo = todoRepository.findById(todo.getId()).orElseThrow(() -> new FailedToEditException("Failed to update " + todo.getId() + ". Todo dosn't exist"));
        if (!userService.fetchCurrentUser().getId().equals(existingTodo.getUserId())) {
            throw new FailedToEditException("Failed to update " + todo.getId() + ". Access denied.");
        }
        return todoRepository.save(fillCurrentUserId(todo));
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(fillCurrentUserId(todo));
    }

    public void deleteTodo(Integer id) {
        fetchCurrentUserTodoList().stream().filter(todo -> todo.getId().equals(id)).findFirst().ifPresent(todoRepository::delete);
    }

    private Todo fillCurrentUserId(Todo todo) {
        return new Todo(todo, userService.fetchCurrentUser().getId());
    }
}
