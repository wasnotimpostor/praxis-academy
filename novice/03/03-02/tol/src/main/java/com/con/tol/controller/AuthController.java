package com.con.tol.controller;

import java.net.URI;

import com.con.tol.exception.AppException;
import com.con.tol.model.Role;
import com.con.tol.model.RoleName;
import com.con.tol.model.User;
import com.con.tol.payload.ApiResponse;
import com.con.tol.payload.JwtAuthenticationResponse;
import com.con.tol.payload.LoginRequest;
import com.con.tol.payload.SignUpRequest;
import com.con.tol.repository.RoleRepo;
import com.con.tol.repository.UserRepo;
import com.con.tol.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

//import javax.validation.Valid;
import java.util.Collections;

@RestController
@RequestMapping(path = "/tol")
public class AuthController {
    
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepo userRepo;

    @Autowired
    RoleRepo roleRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;

    @PostMapping(path = "/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                loginRequest.getUsernameOrEmail(),
                loginRequest.getPassword()
            )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @PostMapping(path = "/register")
    public ResponseEntity<?> registerUser(@RequestBody SignUpRequest signUpRequest) {
        if(userRepo.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity(new ApiResponse(false, "Username sudah dipakai"), HttpStatus.BAD_REQUEST);
        }
        if(userRepo.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email sudah dipakai"), HttpStatus.BAD_REQUEST);
        }

        // create user's account
        User user = new User(signUpRequest.getName(), signUpRequest.getEmail(), signUpRequest.getUsername(), signUpRequest.getPassword());
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role userRole = roleRepo.findByName(RoleName.ROLE_USER).orElseThrow(() -> new AppException("User role not set"));

        user.setRoles(Collections.singleton(userRole));

        User result = userRepo.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentContextPath().path("/tol/users/{username}").buildAndExpand(result.getUsername()).toUri();
        return ResponseEntity.created(location).body(new ApiResponse(true, "Register sukses"));
    }
}
