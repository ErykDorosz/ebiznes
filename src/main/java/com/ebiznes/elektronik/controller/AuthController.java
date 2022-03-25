package com.ebiznes.elektronik.controller;

import com.ebiznes.elektronik.dto.LoginRequest;
import com.ebiznes.elektronik.dto.LoginResponse;
import com.ebiznes.elektronik.dto.RegisterRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.ebiznes.elektronik.service.AuthService;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController()
@RequestMapping("/auth")
@Tag(name = "Auth")
@RequiredArgsConstructor
public class AuthController
{

    private final AuthService authService;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody @Valid LoginRequest loginRequest) {
        return authService.loginUser(loginRequest);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterRequest registerRequest) {
        authService.registerUser(registerRequest);
        return ResponseEntity.ok().build();
    }
}
