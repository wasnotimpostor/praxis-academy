package kasus.toko.vapor.controller;

import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kasus.toko.vapor.message.request.LoginForm;
import kasus.toko.vapor.message.request.SignUpForm;
import kasus.toko.vapor.message.response.JwtResponse;
import kasus.toko.vapor.model.NamaRole;
import kasus.toko.vapor.model.Role;
import kasus.toko.vapor.model.User;
import kasus.toko.vapor.repository.BarangRepository;
import kasus.toko.vapor.repository.RoleRepository;
import kasus.toko.vapor.repository.Toko1Repository;
import kasus.toko.vapor.repository.UserRepository;
import kasus.toko.vapor.security.jwt.JwtProvider;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/kasus")
public class AuthRestAPI {
    
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    Toko1Repository toko1Repository;

    @Autowired
    BarangRepository BarangRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginForm) {
 
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginForm.getUsername(),
                        loginForm.getPassword()));
 
        SecurityContextHolder.getContext().setAuthentication(authentication);
 
        String jwt = jwtProvider.generateJwtToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpForm signUpForm) {
        if(userRepository.existsByUsername(signUpForm.getUsername())) {
            return new ResponseEntity<String>("GAGAL! >> Username sudah dipakai!", HttpStatus.BAD_REQUEST);
        }

        // register user
        User user = new User(signUpForm.getNama(), signUpForm.getUsername(), encoder.encode(signUpForm.getPassword()));

        Set<String> strRoles = signUpForm.getRole();
        Set<Role> roles = new HashSet<>();

        strRoles.forEach(role -> {
            switch (role) {
                case "admin":
                    Role adminRole = roleRepository.findByNama(NamaRole.ROLE_ADMIN).orElseThrow(() ->
                    new RuntimeException("GAGAL! Role tidak ditemukan!"));
                    roles.add(adminRole);
                    break;

                case "toko1" :
                    Role toko1Role = roleRepository.findByNama(NamaRole.ROLE_TOKO1).orElseThrow(() ->
                    new RuntimeException("GAGAL! Role tidak ditemukan!"));
                    roles.add(toko1Role);
                    break;
                case "toko2":
                    Role toko2Role = roleRepository.findByNama(NamaRole.ROLE_TOKO2).orElseThrow(() ->
                    new RuntimeException("GAGAL! Role tidak ditemukan!"));
                    roles.add(toko2Role);
                    break;
                default:
                    Role buyerRole = roleRepository.findByNama(NamaRole.ROLE_BUYER).orElseThrow(() ->
                    new RuntimeException("GAGAL! Role tidak ditemukan!"));
                    roles.add(buyerRole);
                    break;
            }
        });

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok().body("Register berhasil gaes!");
    }
}
