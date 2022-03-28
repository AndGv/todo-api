package com.itacademy.todo.service;

import com.itacademy.todo.exception.FailedToCreateException;
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
        return fetchCurrentUserTodoList().stream()
                .filter(t -> t.getId().equals(todo.getId()))
                .findFirst().map(todoRepository::save).orElseThrow(() -> new FailedToEditException("Failed to update " + todo.getId()));
    }

    public Todo createTodo(Todo todo) {
        if (userService.fetchCurrentUser().getId().equals(todo.getUserId())) {
            return todoRepository.save(todo);
        }
        throw new FailedToCreateException("Presented userId is invalid");
    }

    public void deleteTodo(Integer id) {
        fetchCurrentUserTodoList().stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst().ifPresent(todoRepository::delete);
    }
}
