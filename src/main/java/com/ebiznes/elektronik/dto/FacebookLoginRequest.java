package com.ebiznes.elektronik.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class FacebookLoginRequest {
    @NotNull
    @Email
    private final String email;
    @NotNull
    private final String firstName;
    @NotNull
    private final String lastName;
    @NotNull
    private final String accessToken;
}
