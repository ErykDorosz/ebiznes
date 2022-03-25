package com.ebiznes.elektronik.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginResponse {
    @NotNull
    private final String token;
}
