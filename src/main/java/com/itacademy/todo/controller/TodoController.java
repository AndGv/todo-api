package com.itacademy.todo.controller;

import com.itacademy.todo.model.Todo;
import com.itacademy.todo.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> todoList() {
        return todoService.fetchCurrentUserTodoList();
    }

    @PutMapping
    public Todo updateTodo(@RequestBody Todo todo) {
        return todoService.updateTodo(todo);
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteTodo(@RequestParam Integer id) {
        todoService.deleteTodo(id);
    }

}
