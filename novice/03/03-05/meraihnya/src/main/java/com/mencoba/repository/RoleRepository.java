package com.mencoba.repository;

import java.util.Optional;

import com.mencoba.model.Role;
import com.mencoba.model.RoleName;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}