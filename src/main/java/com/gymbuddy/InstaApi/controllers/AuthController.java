package com.gymbuddy.InstaApi.controllers;

import com.gymbuddy.InstaApi.Security.DTOs.LogInDTO;
import com.gymbuddy.InstaApi.Security.DTOs.RegistrationDTO;
import com.gymbuddy.InstaApi.entitys.Roles;
import com.gymbuddy.InstaApi.entitys.Users;
import com.gymbuddy.InstaApi.repository.UserRepo;
import com.gymbuddy.InstaApi.repository.rolesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepo uRepo;
    @Autowired
    private rolesRepo rRepol;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    JwtAuthenticationResource jwtAuthenticationResource;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegistrationDTO userCredentials) {
        if (uRepo.existsByUserName(userCredentials.getUserName())){
            return new ResponseEntity<>("Username Taken Please Try Again", HttpStatus.BAD_REQUEST);
        }
        Users user = new Users();
        user.setUserName(userCredentials.getUserName());
        user.setPassword(passwordEncoder.encode(userCredentials.getPassword()));
        user.setFname(userCredentials.getFirstName());
        user.setLname(userCredentials.getLastName());

        Roles role = rRepol.findByRole("USER");
        user.setRoles(Collections.singleton(role));

        uRepo.save(user);

        return new ResponseEntity<>("User created", HttpStatus.CREATED);


    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LogInDTO userCredentials){
        Authentication auth = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userCredentials.getUserName(), userCredentials.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(auth);
        var token = jwtAuthenticationResource.autehnticate(auth);
        return new ResponseEntity<>(token.toString(), HttpStatus.OK);
    }
}

record JwtResponse(String token) {}