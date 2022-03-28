package com.itacademy.todo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Todo {
    @Id
    private Integer id;
    private String name;
    private String description;
    private Date dueDate;
    @JsonIgnore
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public Integer getUserId() {
        return userId;
    }
}
