package com.itacademy.todo.controller;

import com.itacademy.todo.model.Todo;
import com.itacademy.todo.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Integer id, @RequestBody Todo todo) {
        return todoService.updateTodo(id, todo);
    }

    @PostMapping
    public Todo createTodo(@RequestBody @Valid Todo todo) {
        return todoService.createTodo(todo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTodo(@PathVariable Integer id) {
        todoService.deleteTodo(id);
    }

}
