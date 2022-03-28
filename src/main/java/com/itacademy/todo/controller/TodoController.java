package com.itacademy.todo.controller;

import com.itacademy.todo.config.security.TodoUserDetailsService;
import com.itacademy.todo.model.Todo;
import com.itacademy.todo.model.User;
import com.itacademy.todo.service.TodoService;
import com.itacademy.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/todos")
public class TodoController {

    private final TodoService todoService;
    private final UserService userService;

    public TodoController(TodoService todoService, UserService userService) {
        this.userService = userService;
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> todoList() {
        return todoService.fetchTodoListByUserId(userService.fetchCurrentUser().getId());
    }

}
