package com.impian.controller;

import com.impian.message.request.LoginForm;
import com.impian.message.request.SignUpForm;
import com.impian.message.response.JwtResponse;
import com.impian.model.*;
import com.impian.repository.BarangRepository;
import com.impian.repository.RoleRepository;
import com.impian.repository.TokoRepository;
import com.impian.repository.UserRepository;
import com.impian.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/kasus")
public class AuthRestAPIs {
 
  @Autowired
  AuthenticationManager authenticationManager;
 
  @Autowired
  UserRepository userRepository;
 
  @Autowired
  RoleRepository roleRepository;

  @Autowired
  TokoRepository tokoRepository;

  @Autowired
  BarangRepository barangRepository;
 
  @Autowired
  PasswordEncoder encoder;
 
  @Autowired
  JwtProvider jwtProvider;
 
  @PostMapping("/login")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {
 
      Authentication authentication = authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken(
                      loginRequest.getUsername(),
                      loginRequest.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(authentication);
 
    String jwt = jwtProvider.generateJwtToken(authentication);
    return ResponseEntity.ok(new JwtResponse(jwt));
  }
 
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<>("GAGAL -> Username sudah dipakai", HttpStatus.BAD_REQUEST);
        }
 
        // Creating user's account
        User user = new User(signUpRequest.getName(), signUpRequest.getUsername(), encoder.encode(signUpRequest.getPassword()));
 
        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();
 
        strRoles.forEach(role -> {
          switch(role) {
          case "admin":
                Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                  .orElseThrow(() -> new RuntimeException("Role tidak ditemukan!"));
                roles.add(adminRole);
                break;          
          case "toko1":
                Role toko1Role = roleRepository.findByName(RoleName.ROLE_TOKO1)
                  .orElseThrow(() -> new RuntimeException("Role tidak ditemukan!"));
                roles.add(toko1Role);
                break;
          case "toko2" :
                Role toko2Role = roleRepository.findByName(RoleName.ROLE_TOKO2)
                  .orElseThrow(() -> new RuntimeException("Role tidak ditemukan!"));
                  roles.add(toko2Role);
                break;
          default:
              Role buyerRole = roleRepository.findByName(RoleName.ROLE_BUYER)
                  .orElseThrow(() -> new RuntimeException("Role tidak ditemukan!"));
              roles.add(buyerRole);              
          }
        });
        
        user.setRoles(roles);
        userRepository.save(user);
 
        return ResponseEntity.ok().body("Register berhasil gaes!");
    }

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
  
  @GetMapping("/admin")
  @PreAuthorize("hasRole('ADMIN')")
  public @ResponseBody List<Toko> getAllToko() {
    return tokoRepository.findAll();
  }

  @GetMapping("/admin/barang")
  @PreAuthorize("hasRole('ADMIN')")
  public @ResponseBody List<Barang> getAllBarang() { return barangRepository.findAll(); }

  @GetMapping("/admin/users")
    @PreAuthorize("hasRole('ADMIN')")
    public  @ResponseBody List<User> getAllUsers() { return userRepository.findAll(); }
}