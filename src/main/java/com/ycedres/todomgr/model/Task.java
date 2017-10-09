package com.ycedres.todomgr.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tasks")
public class Task {

    @Id
    @Column
    @GeneratedValue
    private Integer id;

    @Column
    @NotNull
    String description;

    public Task() {

    }

    public Task(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

