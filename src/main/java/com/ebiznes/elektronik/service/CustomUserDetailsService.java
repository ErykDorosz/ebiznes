package com.ebiznes.elektronik.service;

import com.ebiznes.elektronik.dto.CustomUserDetails;
import com.ebiznes.elektronik.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        val user = userRepository
                .findByEmail(username)
                .orElseThrow(IllegalArgumentException::new);

        return CustomUserDetails.of(user);
    }
}
