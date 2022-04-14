package com.itacademy.todo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

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

    private LocalDate dueDate;
    @JsonIgnore
    private Integer userId;

    public Todo() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setUserId(Integer userId) {
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

    public LocalDate getDueDate() {
        return dueDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public boolean isDone() {
        return done;
    }
}
