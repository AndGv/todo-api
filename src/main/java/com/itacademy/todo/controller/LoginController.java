package com.itacademy.todo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/login")
public class LoginController {

    @GetMapping
    public boolean login() {
        return true;
    }
}
