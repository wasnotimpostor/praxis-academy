package com.mencoba.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRestAPIs {
  
  @GetMapping("/api/auth/user")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
  public String userAccess() {
    return ">>> User Contents!";
  }
  
  @GetMapping("/api/auth/gembel")
  @PreAuthorize("hasRole('GEMBEL') or hasRole('ADMIN')")
  public String gembelAccess() {
    return ">>> Board Management Project";
  }
  
  @GetMapping("/api/auth/admin")
  @PreAuthorize("hasRole('ADMIN')")
  public String adminAccess() {
    return ">>> Admin Contents";
  }
}