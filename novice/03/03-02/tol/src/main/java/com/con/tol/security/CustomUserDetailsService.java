package com.con.tol.security;

import com.con.tol.model.User;
import com.con.tol.repository.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepo userRepo;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        User user = userRepo.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail) .orElseThrow(() ->
        new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail)
        ); return UserPrincipal.create(user);
    }

    public UserDetails loadUserById(Long id) {
        User user = userRepo.findById(id).orElseThrow(() ->
        new UsernameNotFoundException("User not found with id : " + id));
        return UserPrincipal.create(user);
    }
}
