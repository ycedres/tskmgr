package com.ycedres.todomgr.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="users")
public class User {

    @Id
    @Column
    @GeneratedValue
    private Integer id;

    @Column
    @NotNull
    String username;

    @Column
    @NotNull
    String password;

    @Column
    String description;

    public User() {

    }

    public User(String username,String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username,String password,String description) {
        this.username = username;
        this.password = password;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
