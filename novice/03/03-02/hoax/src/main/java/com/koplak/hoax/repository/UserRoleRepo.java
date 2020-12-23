package com.koplak.hoax.repository;

import com.koplak.hoax.model.UserRole;

import org.springframework.data.repository.CrudRepository;

public interface UserRoleRepo extends CrudRepository<UserRole, Long> {
    
}
