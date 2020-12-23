package com.koplak.hoax.repository;

import com.koplak.hoax.model.Role;

import org.springframework.data.repository.CrudRepository;

public interface RoleRepo extends CrudRepository<Role, Long> {
    
}
