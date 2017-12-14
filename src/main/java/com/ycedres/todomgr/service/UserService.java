package com.ycedres.todomgr.service;

import com.ycedres.todomgr.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAll();
    public List<User> getAllUsers();
    public String getUserName(User u);
}
