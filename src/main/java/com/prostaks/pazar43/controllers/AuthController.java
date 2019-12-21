package com.prostaks.pazar43.controllers;

import com.prostaks.pazar43.security.JwtAuthenticationResponse;
import com.prostaks.pazar43.security.JwtTokenProvider;
import com.prostaks.pazar43.security.UserPrincipal;
import com.prostaks.pazar43.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@CrossOrigin("*")
@RestController
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @RequestMapping("/current_user")
    public UserPrincipal GetCurrentUser(HttpServletRequest request) throws Exception {
        String token = request.getHeader("Authorization").substring(7);
        int id = jwtTokenProvider.getUserIdFromJWT(token);
        return (UserPrincipal) customUserDetailsService.loadUserById(id);
    }

    @PostMapping("/login")
    public ResponseEntity<?> LoginUser(@RequestBody Map<String,String> body){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        body.get("username"),
                        body.get("password")
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtTokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }
}
