package com.gymbuddy.InstaApi.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.stream.Collectors;

@Component
public class JwtAuthenticationResource {

    private JwtEncoder jwtEncoder;

    public JwtAuthenticationResource(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }

    public JwtResponse autehnticate(Authentication auth){
        return new JwtResponse(createToken(auth));
    }

    private String createToken(Authentication auth){
        var claims = JwtClaimsSet.builder().issuer("self")
                .issuedAt(Instant.now())
                .expiresAt(Instant.now()
                        .plusSeconds(60*30)).claim("scope", createScope(auth)).build();
        JwtEncoderParameters parameters = JwtEncoderParameters.from(claims);
        return jwtEncoder.encode(parameters).getTokenValue();
    }

    private String createScope(Authentication auth) {
        return auth
                .getAuthorities()
                .stream()
                .map(a -> a.getAuthority())
                .collect(Collectors.joining(" "));
    }
}


