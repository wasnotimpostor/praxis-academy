package com.tas.tas.repository;

import java.util.Optional;

import com.tas.tas.model.Role;
import com.tas.tas.model.RoleName;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
