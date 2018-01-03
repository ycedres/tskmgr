package com.ycedres.todomgr.web.users;

import com.ycedres.todomgr.model.User;
import com.ycedres.todomgr.service.UserService;
import com.ycedres.todomgr.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

public class ShowUser {

    @Autowired
    private UserServiceImpl userService;

    private List<User> userList;


    public ShowUser() {
        userList = userService.getAllUsers();
    }

    public void UnMetodo(){
        int a = 1;
    }
}
