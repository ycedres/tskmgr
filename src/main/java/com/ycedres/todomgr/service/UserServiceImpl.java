package com.ycedres.todomgr.service;

import com.ycedres.todomgr.model.User;
import com.ycedres.todomgr.model.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

import org.slf4j.Logger;


@Service
@Component
public class UserServiceImpl implements UserService{

    public static final Logger log = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        if (this.userRepository == null) {
            log.info("userRepository es null");
        }
        return this.userRepository.findAll();
    }


    public List<User> getAllUsers() {
        if (this.userRepository == null) {
            log.info("userRepository es null");
        }
        else {
            log.info("userRepository NO es null");
        }
        return this.userRepository.getAllUsers();
    }

    public String getUserName(User u) {
        return this.userRepository.getOne(u.getId()).getUsername();
    }
}
