package com.mencoba.controller;

import java.util.List;

import com.mencoba.model.User;
import com.mencoba.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TestRestAPIs {

  @Autowired
  public UserRepository userRepository;
  
  @GetMapping("/api/auth/user")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
  public String userAccess() {
    return ">>> User Contents!";
  }
  
  @GetMapping("/api/auth/gembel")
  @PreAuthorize("hasRole('GEMBEL') or hasRole('ADMIN')")
  public String gembelAccess() {
    return ">>> Gembel Contents!";
  }
  
  @GetMapping("/api/auth/admin")
  @PreAuthorize("hasRole('ADMIN')")
  public @ResponseBody List<User> getAllUser() {
    return userRepository.findAll();
  }
}