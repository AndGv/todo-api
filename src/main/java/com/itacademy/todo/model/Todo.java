package com.itacademy.todo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Todo {
    @Id
    @GeneratedValue(generator = "todo_id_seq")
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String description;
    @Column(name = "isDone")
    private boolean done;
    private Date dueDate;
    @JsonIgnore
    private Integer userId;

    public Todo() {
    }

    public Todo(Todo todo, Integer userId) {
        this.id = todo.getId();
        this.name = todo.getName();
        this.description = todo.getDescription();
        this.dueDate = todo.getDueDate();
        this.done = todo.isDone();
        this.userId = userId;
    }

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

    public boolean isDone() {
        return done;
    }
}
