package com.ebiznes.elektronik.controller;

import com.ebiznes.elektronik.dto.FacebookLoginRequest;
import com.ebiznes.elektronik.dto.LoginRequest;
import com.ebiznes.elektronik.dto.LoginResponse;
import com.ebiznes.elektronik.dto.RegisterRequest;
import com.ebiznes.elektronik.service.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/login/facebook")
    public LoginResponse loginFacebook(@RequestBody @Valid FacebookLoginRequest facebookLoginRequest) {
        return authService.loginFacebookUser(facebookLoginRequest);
    }
}
