package com.ebiznes.elektronik.service;

import com.ebiznes.elektronik.dto.LoginRequest;
import com.ebiznes.elektronik.dto.RegisterRequest;
import com.ebiznes.elektronik.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.ebiznes.elektronik.repository.UserRepository;
import lombok.val;


@Service
@RequiredArgsConstructor
public class AuthService
{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void loginUser(LoginRequest loginRequest) {

    }

    public void registerUser(RegisterRequest registerRequest) {
        val user = User.builder()
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .name(registerRequest.getFirstName())
                .surname(registerRequest.getLastName())
                .isAdmin(false)
                .build();
        userRepository.save(user);

    }
}
