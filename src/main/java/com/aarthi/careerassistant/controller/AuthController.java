package com.aarthi.careerassistant.controller;

import com.aarthi.careerassistant.dto.LoginRequest;
import com.aarthi.careerassistant.dto.UserRequest;
import com.aarthi.careerassistant.entity.User;
import com.aarthi.careerassistant.service.UserService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User register(
            @Valid @RequestBody UserRequest request) {

        return userService.registerUser(request);
    }
    @PostMapping("/login")
    public String login(
            @RequestBody LoginRequest request) {

        return userService.loginUser(request);
    }
}