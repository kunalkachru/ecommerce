package com.ecommerce.auth_service.controller;

import com.ecommerce.auth_service.entity.User;
import com.ecommerce.auth_service.dto.AuthRequest;
import com.ecommerce.auth_service.dto.AuthResponse;
import com.ecommerce.auth_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    // Register endpoint
    @PostMapping("/register")
    public AuthResponse register(@RequestBody User user) {
        return userService.register(user);
    }

    // Login endpoint
    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        return userService.login(request);
    }

    // Secured endpoint to test JWT
    @GetMapping("/me")
    public String me() {
        return "You are authenticated!";
    }
}
