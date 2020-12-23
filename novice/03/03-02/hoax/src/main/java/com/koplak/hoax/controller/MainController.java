package com.koplak.hoax.controller;

import com.koplak.hoax.model.User;
import com.koplak.hoax.repository.RoleRepo;
import com.koplak.hoax.repository.UserRepo;
import com.koplak.hoax.repository.UserRoleRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MainController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;
    
    @Autowired
    private UserRoleRepo userRoleRepo;

    @PostMapping(path = "/kontol")
    public User addUser(@RequestBody User user) {
        return userRepo.save(user);
    }
}
