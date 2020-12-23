package com.koplak.hoax.repository;

import com.koplak.hoax.model.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
    
}
