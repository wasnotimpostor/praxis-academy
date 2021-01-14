package uvuvwevwevwe.onyetenyevwe.ugwemubwem.ossas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import uvuvwevwevwe.onyetenyevwe.ugwemubwem.ossas.message.request.LoginForm;
import uvuvwevwevwe.onyetenyevwe.ugwemubwem.ossas.message.request.SignUpForm;
import uvuvwevwevwe.onyetenyevwe.ugwemubwem.ossas.message.response.JwtResponse;
import uvuvwevwevwe.onyetenyevwe.ugwemubwem.ossas.model.Role;
import uvuvwevwevwe.onyetenyevwe.ugwemubwem.ossas.model.RoleName;
import uvuvwevwevwe.onyetenyevwe.ugwemubwem.ossas.model.User;
import uvuvwevwevwe.onyetenyevwe.ugwemubwem.ossas.repository.*;
import uvuvwevwevwe.onyetenyevwe.ugwemubwem.ossas.security.jwt.JwtProvider;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/ossas")
public class MainController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    AllTokoRepo allTokoRepo;

    @Autowired
    TokoVapeRepo vapeRepo;

    @Autowired
    TokoSembakoRepo sembakoRepo;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(),
                loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateJwtToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<>("GAGAL! -> Username Sudah Digunakan!", HttpStatus.BAD_REQUEST);
        }

        // Create user account
        User user = new User(signUpRequest.getName(), signUpRequest.getUsername(), encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        strRoles.forEach(role -> {
            switch (role) {
                case "admin":
                    Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                            .orElseThrow(() -> new RuntimeException("Role tidak ditemukan!"));
                    roles.add(adminRole);
                    break;
                default:
                    Role buyerRole = roleRepository.findByName(RoleName.ROLE_BUYER)
                            .orElseThrow(() -> new RuntimeException("Role tidak ditemukan!"));
                    roles.add(buyerRole);
            }
        });

        user.setRoles(roles);
        userRepository.save(user);
        return ResponseEntity.ok().body("Register Sukses Gaes!");
    }
}
