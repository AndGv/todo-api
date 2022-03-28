package com.itacademy.todo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.itacademy.todo.repo.UserRepository;
import jakarta.persistence.*;

@Entity
@Table(name = "todo_user")
public class User {
    @Id
    private Integer id;
    private String name;
    @JsonIgnore
    @Column(nullable = false, unique = true)
    private String username;
    @JsonIgnore
    private String password;

    public User() {
    }

    public User(Integer id, String name, String username, String password) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
